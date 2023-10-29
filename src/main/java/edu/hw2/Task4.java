package edu.hw2;

public class Task4 {
    /**
     * 4. ��� ������ �������?
     * �������� ����������� ������� callingInfo, ������� ����������     *
     * public record CallingInfo(String className, String methodName) {}
     * ��� ��������� ������� � ����� ������ ����������� ����� Throwable#getStackTrace.
     */
    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        // ������ 2 ������������� ������ callingInfo(), 3 - ����������� ������, � ��� �����
        if (stackTrace.length > 3) {
            StackTraceElement caller = stackTrace[3];
            String className = caller.getClassName();
            String methodName = caller.getMethodName();
            return new CallingInfo(className, methodName);
        } else {
            // ���� ���� ������� ������� ��������, ������ �������� �� ���������
            return new CallingInfo("Unknown", "Unknown");
        }
    }
    public record CallingInfo(String className, String methodName) {}
}
