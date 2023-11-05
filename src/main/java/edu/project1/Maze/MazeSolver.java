package edu.Maze;

import java.util.*;

public class MazeSolver {

    public List<Coordinate> solveMaze(Maze maze, Coordinate start, Coordinate end) {
        List<Coordinate> path = new ArrayList<>();
        Set<Coordinate> visited = new HashSet<>();
        if (dfs(maze, start, end, path, visited)) {
            return path;
        }
        return Collections.emptyList();
    }

    private boolean dfs(Maze maze, Coordinate current, Coordinate end, List<Coordinate> path, Set<Coordinate> visited) {
        if (current.equals(end)) {
            path.add(current);
            return true;
        }

        if (!visited.contains(current)) {
            visited.add(current);
            path.add(current);

            int row = current.getRow();
            int col = current.getCol();

            int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // ¬верх, вниз, влево, вправо

            for (int[] move : moves) {
                int newRow = row + move[0];
                int newCol = col + move[1];

                if (maze.isValid(newRow, newCol) && maze.isWall(newRow, newCol)) {
                    Coordinate next = new Coordinate(newRow, newCol);
                    if (dfs(maze, next, end, path, visited)) {
                        return true;
                    }
                }
            }

            path.remove(path.size() - 1);
        }

        return false;
    }
}
