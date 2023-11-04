package edu.hw2;

public class Task2 {
    /**
     * 2. ������� � �������������
     * ��� ����� ���� ����� ������������... ������ ��� ���������� ������������.
     * �� �������� �����������, ��� ���������� ������������ ����� ���������� � � ���������� ����� ������ ����� ������������ ���������� ��� ������������ "������" sealed-���������� (ADT).
     * ����� ������������������ ����������� ����, ��������� ��������� ������������ �������� �������������� � ��������.
     * ��������, � ��� ���� ������ Rectangle � Square � �������� setWidth, setHeight � area:
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

    public static class Square {
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
}
