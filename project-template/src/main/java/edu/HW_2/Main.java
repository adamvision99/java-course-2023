package HW_2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //1 hw
//        var two = new Expr.Constant(2);
//        var four = new Expr.Constant(4);
//        var negOne = new Expr.Negate(new Expr.Constant(1));
//        var sumTwoFour = new Expr.Addition(two, four);
//        var mult = new Expr.Multiplication(sumTwoFour, negOne);
//        var exp = new Expr.Exponent(mult, 2);
//        var res = new Expr.Addition(exp, new Expr.Constant(1));
//        System.out.println(res + " = " + res.evaluate());


        //4 hw
//        CallingInfo info = callingInfo();
//        System.out.println("Calling Class: " + info.className());
//        System.out.println("Calling Method: " + info.methodName());
    }
    /**
     * 1. Калькулятор выражений
     * Напишите иерархию классов для вычисления математических выражений.
     * public sealed interface Expr {
     *     double evaluate();
     *     public record Constant implements Expr {}
     *     public record Negate implements Expr {}
     *     public record Exponent implements Expr {}
     *     public record Addition implements Expr {}
     *     public record Multiplication implements Expr {}
     * }
     * Разбор строковых представлений выражений не требуется, достаточно чтобы работал код вида
     */
    public sealed interface Expr {
        double evaluate();

        public record Constant(double value) implements Expr {
            @Override
            public double evaluate() {
                return value;
            }
        }

        public record Negate(Expr operand) implements Expr {
            @Override
            public double evaluate() {
                return -operand.evaluate();
            }
        }

        public record Exponent(Expr base, Integer i) implements Expr {
            @Override
            public double evaluate() {
                return Math.pow(base.evaluate(), i);
            }
        }

        public record Addition(Expr left, Expr right) implements Expr {
            @Override
            public double evaluate() {
                return left.evaluate() + right.evaluate();
            }
        }

        public record Multiplication(Expr left, Expr right) implements Expr {
            @Override
            public double evaluate() {
                return left.evaluate() * right.evaluate();
            }
        }
    }

    /**
     * 2. Квадрат и прямоугольник
     * Что может быть проще наследования... Думают все начинающие программисты.
     * На практике оказывается, что применение наследования очень ограничено и в реальности почти всегда лучше использовать композицию или относительно "глупые" sealed-интерфейсы (ADT).
     * Чтобы продемонстрировать утверждение выше, попробуем разрешить классический парадокс прямоугольника и квадрата.
     * Допустим, у вас есть классы Rectangle и Square с методами setWidth, setHeight и area:
     */
    public static class Rectangle {
        private int width;
        private int height;

        public Rectangle(int width, int height) {
            setWidth(width);
            setHeight(height);
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public double area() {
            return width * height;
        }
    }

    public class Square {
        private final Rectangle rectangle;

        public Square(int sideLength) {
            rectangle = new Rectangle(sideLength, sideLength);
        }

        public void setSideLength(int sideLength) {
            rectangle.setWidth(sideLength);
            rectangle.setHeight(sideLength);
        }

        public int getSideLength() {
            return rectangle.getWidth();
        }

        public double area() {
            return rectangle.area();
        }
    }
    /**
     *3. Удаленный сервер
     * Программист Иван хочет выполнять часто используемые консольные команды на удаленном сервере из Java-программы.
     * Помогите Ивану и реализуйте:
     * 2 типа соединений: StableConnection / FaultyConnection, стабильное соединение работает всегда, проблемное соединение иногда бросает ConnectionException
     * DefaultConnectionManager, который с некоторой вероятностью возвращает проблемное соединение
     * FaultyConnectionManager, который всегда возвращает проблемное соединение
     * Метод tryExecute, который должен попытаться выполнить переданную команду maxAttempts раз
     * Если tryExecute не смог выполнить команду (превышено количество попыток), то нужно вернуть ConnectionException, при этом сохранив оригинальное исключение в параметре cause
     * Обратите внимание, что Connection требуется закрывать (интерфейс AutoCloseable)
     */
    public interface Connection extends AutoCloseable {
        void execute(String command);
    }

    public class ConnectionException extends RuntimeException {}

    public class StableConnection implements Connection {
        @Override
        public void execute(String command) {
            // Реализация стабильного соединения
            System.out.println("Executing command: " + command);
        }

        @Override
        public void close() {
            // Закрытие соединения
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
            // Реализация проблемного соединения
            if (random.nextDouble() < failureRate) {
                throw new RuntimeException("Connection failed");
            }
            System.out.println("Executing command: " + command);
        }

        @Override
        public void close() {
            // Закрытие соединения
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
            return new FaultyConnection(1.0); // Всегда проблемное соединение
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
                    return; // Успешно выполнена команда
                } catch (Exception e) {
                    if (attempt == maxAttempts) {
                        throw new RuntimeException("Failed to execute command after " + maxAttempts + " attempts", e);
                    }
                }
            }
        }
    }
    /**
     * 4. Кто вызвал функцию?
     * Напишите статическую функцию callingInfo, которая возвращает     *
     * public record CallingInfo(String className, String methodName) {}
     * Для получения доступа к стеку вызова используйте метод Throwable#getStackTrace.
     */
    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        // Индекс 2 соответствует методу callingInfo(), 3 - вызывающему методу, и так далее
        if (stackTrace.length > 3) {
            StackTraceElement caller = stackTrace[3];
            String className = caller.getClassName();
            String methodName = caller.getMethodName();
            return new CallingInfo(className, methodName);
        } else {
            // Если стек вызовов слишком короткий, вернем значения по умолчанию
            return new CallingInfo("Unknown", "Unknown");
        }
    }
    public record CallingInfo(String className, String methodName) {}
}