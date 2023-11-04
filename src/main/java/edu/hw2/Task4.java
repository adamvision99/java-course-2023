package edu.hw2;

public class Task4 {
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
