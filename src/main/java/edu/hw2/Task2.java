package edu.hw2;

public class Task2 {
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
