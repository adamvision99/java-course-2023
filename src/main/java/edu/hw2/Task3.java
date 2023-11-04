package edu.hw2;

import java.util.Random;

public class Task3 {
    /**
     *3. ��������� ������
     * ����������� ���� ����� ��������� ����� ������������ ���������� ������� �� ��������� ������� �� Java-���������.
     * �������� ����� � ����������:
     * 2 ���� ����������: StableConnection / FaultyConnection, ���������� ���������� �������� ������, ���������� ���������� ������ ������� ConnectionException
     * DefaultConnectionManager, ������� � ��������� ������������ ���������� ���������� ����������
     * FaultyConnectionManager, ������� ������ ���������� ���������� ����������
     * ����� tryExecute, ������� ������ ���������� ��������� ���������� ������� maxAttempts ���
     * ���� tryExecute �� ���� ��������� ������� (��������� ���������� �������), �� ����� ������� ConnectionException, ��� ���� �������� ������������ ���������� � ��������� cause
     * �������� ��������, ��� Connection ��������� ��������� (��������� AutoCloseable)
     */
    public interface Connection extends AutoCloseable {
        void execute(String command);
    }

    public class ConnectionException extends RuntimeException {}

    public class StableConnection implements Connection {
        @Override
        public void execute(String command) {
            // ���������� ����������� ����������
            System.out.println("Executing command: " + command);
        }

        @Override
        public void close() {
            // �������� ����������
            System.out.println("Closing stable connection");
        }
    }

    public class FaultyConnection implements Connection {
        private final double failureRate;
        private final Random random = new Random();

        public FaultyConnection(double failureRate) {
            this.failureRate = failureRate;
        }

        @Override
        public void execute(String command) {
            // ���������� ����������� ����������
            if (random.nextDouble() < failureRate) {
                throw new RuntimeException("Connection failed");
            }
            System.out.println("Executing command: " + command);
        }

        @Override
        public void close() {
            // �������� ����������
            System.out.println("Closing faulty connection");
        }
    }

    public interface ConnectionManager {
        Connection getConnection();
    }

    public class DefaultConnectionManager implements ConnectionManager {
        private final double failureRate;

        public DefaultConnectionManager(double failureRate) {
            this.failureRate = failureRate;
        }

        @Override
        public Connection getConnection() {
            return new FaultyConnection(failureRate);
        }
    }

    public class FaultyConnectionManager implements ConnectionManager {
        @Override
        public Connection getConnection() {
            return new FaultyConnection(1.0); // ������ ���������� ����������
        }
    }

    public final class PopularCommandExecutor {
        private final ConnectionManager manager;
        private final int maxAttempts;

        public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
            this.manager = manager;
            this.maxAttempts = maxAttempts;
        }

        public void tryExecute(String command) {
            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                try (Connection connection = manager.getConnection()) {
                    connection.execute(command);
                    return; // ������� ��������� �������
                } catch (Exception e) {
                    if (attempt == maxAttempts) {
                        throw new RuntimeException("Failed to execute command after " + maxAttempts + " attempts", e);
                    }
                }
            }
        }
    }
}
