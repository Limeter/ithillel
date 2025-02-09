package homework24;

import java.util.*;

public class VisualizationResult {
    private static final char START = 'S';
    private static final char END = 'E';
    private static final char OBSTACLE = '#';
    private static final char PATH = '*';

    private static final int[][] DIRECTIONS = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public static void main(String[] args) {

        char[][] grid = {
                {'.', '.', '.', '#', '.', '.'},
                {'.', '#', '.', '#', '.', '.'},
                {'.', '#', '.', '.', '#', '.'},
                {'.', '#', '#', '.', '#', '.'},
                {'.', '.', '.', '.', '.', '.'},
        };

        int startX = 0, startY = 0;
        int endX = 4, endY = 5;

        grid[startX][startY] = START;
        grid[endX][endY] = END;

        List<int[]> path = findShortestPath(grid, startX, startY, endX, endY);

        if (path != null) {
            for (int[] step : path) {
                grid[step[0]][step[1]] = PATH;
            }
            grid[startX][startY] = START;
            grid[endX][endY] = END;
        }

        printGrid(grid);
    }

    private static List<int[]> findShortestPath(char[][] grid, int startX, int startY, int endX, int endY) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        Map<String, int[]> parentMap = new HashMap<>();

        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];

            if (x == endX && y == endY) {
                return reconstructPath(parentMap, current);
            }

            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0], newY = y + direction[1];
                if (isValid(grid, newX, newY, visited)) {
                    int[] next = new int[]{newX, newY};
                    queue.add(next);
                    visited[newX][newY] = true;
                    parentMap.put(newX + "," + newY, current);
                }
            }
        }
        return null;
    }

    private static List<int[]> reconstructPath(Map<String, int[]> parentMap, int[] end) {
        List<int[]> path = new ArrayList<>();
        for (int[] at = end; at != null; at = parentMap.get(at[0] + "," + at[1])) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }

    private static boolean isValid(char[][] grid, int x, int y, boolean[][] visited) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] != OBSTACLE && !visited[x][y];
    }

    private static void printGrid(char[][] grid) {
        for (char[] row : grid) {
            System.out.println(new String(row));
        }
    }
}
