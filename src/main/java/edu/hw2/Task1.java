package edu.hw2;

public class Task1 {
    /**
     * 1. ����������� ���������
     * �������� �������� ������� ��� ���������� �������������� ���������.
     * public sealed interface Expr {
     *     double evaluate();
     *     public record Constant implements Expr {}
     *     public record Negate implements Expr {}
     *     public record Exponent implements Expr {}
     *     public record Addition implements Expr {}
     *     public record Multiplication implements Expr {}
     * }
     * ������ ��������� ������������� ��������� �� ���������, ���������� ����� ������� ��� ����
     */
    public sealed interface Expr {
        double evaluate();

        record Constant(double value) implements Expr {
            @Override
            public double evaluate() {
                return value;
            }
        }

        record Negate(Expr operand) implements Expr {
            @Override
            public double evaluate() {
                return -operand.evaluate();
            }
        }

        record Exponent(Expr base, Integer i) implements Expr {
            @Override
            public double evaluate() {
                return Math.pow(base.evaluate(), i);
            }
        }

        record Addition(Expr left, Expr right) implements Expr {
            @Override
            public double evaluate() {
                return left.evaluate() + right.evaluate();
            }
        }

        record Multiplication(Expr left, Expr right) implements Expr {
            @Override
            public double evaluate() {
                return left.evaluate() * right.evaluate();
            }
        }
    }
}
