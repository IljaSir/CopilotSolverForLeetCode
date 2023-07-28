class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        List<List<String>> solutions = new ArrayList<>();
        List<Integer> queens = new ArrayList<>();
        solveNQueens(solutions, queens, n);
        return solutions;
    }

    private void solveNQueens(List<List<String>> solutions, List<Integer> queens, int n) {
        if (queens.size() == n) {
            solutions.add(toBoard(queens, n));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!queens.contains(i)) {
                if (isValid(queens, i)) {
                    queens.add(i);
                    solveNQueens(solutions, queens, n);
                    queens.remove(queens.size() - 1);
                }
            }
        }
    }

    private boolean isValid(List<Integer> queens, int column) {
        int row = queens.size();
        for (int i = 0; i < queens.size(); i++) {
            if (queens.get(i) == column) {
                return false;
            }
            if (Math.abs(row - i) == Math.abs(column - queens.get(i))) {
                return false;
            }
        }
        return true;
    }

    private List<String> toBoard(List<Integer> queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < queens.size(); i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == queens.get(i)) {
                    builder.append("Q");
                } else {
                    builder.append(".");
                }
            }
            board.add(builder.toString());
        }
        return board;
    }
}