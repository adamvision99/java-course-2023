package edu.Maze;

import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.*;


public class MazeTest {

    @Test
    public void testMazeGeneration() {
        // Проверка генерации лабиринта
        int height = 10;
        int width = 10;
        Maze maze = MazeGenerator.generateMaze(height, width);

        // Проверка размеров лабиринта
        assertEquals(height, maze.getHeight());
        assertEquals(width, maze.getWidth());

        // Проверка, что не все клетки лабиринта - стены
        boolean hasPassage = false;
        Maze.Cell[][] grid = maze.getGrid();
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (grid[row][col] == Maze.Cell.PASSAGE) {
                    hasPassage = true;
                    break;
                }
            }
        }
        assertTrue(hasPassage);
    }

    @Test
    public void testMazeSolver() {
        // Проверка решения лабиринта
        int height = 10;
        int width = 10;
        Maze maze = MazeGenerator.generateMaze(height, width);

        // Выбираем стартовую и конечную точки
        Coordinate start = new Coordinate(0, 0);
        Coordinate end = new Coordinate(height - 1, width - 1);

        // Решаем лабиринт
        MazeSolver solver = new MazeSolver();
        List<Coordinate> path = solver.solveMaze(maze, start, end);

        // Проверяем, что путь существует
        assertFalse(path.isEmpty());

        // Проверяем, что путь начинается с стартовой точки и заканчивается конечной
        assertEquals(start, path.get(0));
        assertEquals(end, path.get(path.size() - 1));
    }
}
