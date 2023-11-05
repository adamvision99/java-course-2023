package edu.Maze;

public class Maze {
    private final int height;
    private final int width;
    private final Cell[][] grid;

    public Maze(int height, int width) {
        this.height = height;
        this.width = width;
        this.grid = new Cell[height][width];
        initializeGrid();
    }

    private void initializeGrid(){
        // Инициализация лабиринта: устанавливаем все клетки как стены
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                grid[row][col] = Cell.WALL;
            }
        }
    }

    public void setCell(int row, int col, Cell cell) {
        if (row >= 0 && row < height && col >= 0 && col < width) {
            grid[row][col] = cell;
        }
    }

    public boolean isWall(int row, int col) {
        return isValid(row, col, height, width) && grid[row][col] == Cell.WALL;
    }

    public boolean isValid(int row, int col, int height, int width) {
        return row >= 0 && row < height && col >= 0 && col < width;
    }

    public boolean isValid(int row, int col) {
        return row >= 0 && row < height && col >= 0 && col < width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public enum Cell { WALL, PASSAGE }
}