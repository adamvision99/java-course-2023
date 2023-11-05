package edu.Maze;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class MazeGenerator {

    public static Maze generateMaze(int height, int width) {
        Maze maze = new Maze(height, width);
        Random random = new Random();

        // �������� ��������� ��������� ������ � �������� � ��� ������
        int startRow = random.nextInt(height);
        int startCol = random.nextInt(width);
        maze.setCell(startRow, startCol, Maze.Cell.PASSAGE);

        // ������� ���� ��� ������������ �������� ����
        Stack<Coordinate> pathStack = new Stack<>();
        pathStack.push(new Coordinate(startRow, startCol));

        // �������� ���������
        while (!pathStack.isEmpty()) {
            Coordinate currentCell = pathStack.peek();
            int currentRow = currentCell.getRow();
            int currentCol = currentCell.getCol();

            // �������� �������� ������
            Coordinate[] neighbors = getNeighbors(currentRow, currentCol, height, width);
            int availableNeighbors = 0;
            for (Coordinate neighbor : neighbors) {
                int neighborRow = neighbor.getRow();
                int neighborCol = neighbor.getCol();
                if (isValid(neighborRow, neighborCol, height, width) && maze.isWall(neighborRow, neighborCol)) {
                    availableNeighbors++;
                }
            }

            if (availableNeighbors > 0) {
                // ���� ��������� ������, �������� ����������
                int randomNeighborIndex = random.nextInt(neighbors.length);
                Coordinate randomNeighbor = neighbors[randomNeighborIndex];
                int neighborRow = randomNeighbor.getRow();
                int neighborCol = randomNeighbor.getCol();

                // ������� ������ �� ���������� ������
                maze.setCell(neighborRow, neighborCol, Maze.Cell.PASSAGE);
                // ������� ����� ����� ������� ������� � �������
                maze.setCell(currentRow, currentCol, Maze.Cell.PASSAGE);
                // �������� ������ � ����
                pathStack.push(randomNeighbor);
            } else {
                // ������� ������� ������ �� �����, ��� ��� ��� ������ �� ����� ��������� �������
                pathStack.pop();
            }
        }

        return maze;
    }

    private static boolean isValid(int row, int col, int height, int width) {
        return row >= 0 && row < height && col >= 0 && col < width;
    }

    private static Coordinate[] getNeighbors(int row, int col, int height, int width) {
        Coordinate[] neighbors = {
                new Coordinate(row - 2, col),
                new Coordinate(row + 2, col),
                new Coordinate(row, col - 2),
                new Coordinate(row, col + 2)
        };
        return Arrays.stream(neighbors)
                .filter(neighbor -> isValid(neighbor.getRow(), neighbor.getCol(), height, width))
                .toArray(Coordinate[]::new);
    }

}