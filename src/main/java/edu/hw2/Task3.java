package edu.hw2;

import java.util.Random;

public class Task3 {
    /**
     *3. ”даленный сервер
     * ѕрограммист »ван хочет выполн€ть часто используемые консольные команды на удаленном сервере из Java-программы.
     * ѕомогите »вану и реализуйте:
     * 2 типа соединений: StableConnection / FaultyConnection, стабильное соединение работает всегда, проблемное соединение иногда бросает ConnectionException
     * DefaultConnectionManager, который с некоторой веро€тностью возвращает проблемное соединение
     * FaultyConnectionManager, который всегда возвращает проблемное соединение
     * ћетод tryExecute, который должен попытатьс€ выполнить переданную команду maxAttempts раз
     * ≈сли tryExecute не смог выполнить команду (превышено количество попыток), то нужно вернуть ConnectionException, при этом сохранив оригинальное исключение в параметре cause
     * ќбратите внимание, что Connection требуетс€ закрывать (интерфейс AutoCloseable)
     */
    public interface Connection extends AutoCloseable {
        void execute(String command);
    }

    public class ConnectionException extends RuntimeException {}

    public class StableConnection implements Connection {
        @Override
        public void execute(String command) {
            // –еализаци€ стабильного соединени€
            System.out.println("Executing command: " + command);
        }

        @Override
        public void close() {
            // «акрытие соединени€
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
            // –еализаци€ проблемного соединени€
            if (random.nextDouble() < failureRate) {
                throw new RuntimeException("Connection failed");
            }
            System.out.println("Executing command: " + command);
        }

        @Override
        public void close() {
            // «акрытие соединени€
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
            return new FaultyConnection(1.0); // ¬сегда проблемное соединение
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
                    return; // ”спешно выполнена команда
                } catch (Exception e) {
                    if (attempt == maxAttempts) {
                        throw new RuntimeException("Failed to execute command after " + maxAttempts + " attempts", e);
                    }
                }
            }
        }
    }
}
