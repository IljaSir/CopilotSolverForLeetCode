class Solution {
    public String tictactoe(int[][] moves) {
        
        int[][] grid = new int[3][3];
        int n = moves.length;
        for (int i = 0; i < n; i++) {
            int[] move = moves[i];
            if (i % 2 == 0) {
                grid[move[0]][move[1]] = 1;
            } else {
                grid[move[0]][move[1]] = 2;
            }
        }
        if (grid[0][0] == 1 && grid[0][1] == 1 && grid[0][2] == 1) {
            return "A";
        } else if (grid[1][0] == 1 && grid[1][1] == 1 && grid[1][2] == 1) {
            return "A";
        } else if (grid[2][0] == 1 && grid[2][1] == 1 && grid[2][2] == 1) {
            return "A";
        } else if (grid[0][0] == 1 && grid[1][0] == 1 && grid[2][0] == 1) {
            return "A";
        } else if (grid[0][1] == 1 && grid[1][1] == 1 && grid[2][1] == 1) {
            return "A";
        } else if (grid[0][2] == 1 && grid[1][2] == 1 && grid[2][2] == 1) {
            return "A";
        } else if (grid[0][0] == 1 && grid[1][1] == 1 && grid[2][2] == 1) {
            return "A";
        } else if (grid[0][2] == 1 && grid[1][1] == 1 && grid[2][0] == 1) {
            return "A";
        } else if (grid[0][0] == 2 && grid[0][1] == 2 && grid[0][2] == 2) {
            return "B";
        } else if (grid[1][0] == 2 && grid[1][1] == 2 && grid[1][2] == 2) {
            return "
    }
}