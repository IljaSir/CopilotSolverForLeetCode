class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        
        int[] ans = new int[queries.length];
        Set<Integer> lampSet = new HashSet<>();
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();
        Map<Integer, Integer> diagMap = new HashMap<>();
        Map<Integer, Integer> antiDiagMap = new HashMap<>();
        for (int[] lamp : lamps) {
            int row = lamp[0], col = lamp[1];
            int key = row * n + col;
            if (lampSet.contains(key)) {
                continue;
            }
            lampSet.add(key);
            rowMap.put(row, rowMap.getOrDefault(row, 0) + 1);
            colMap.put(col, colMap.getOrDefault(col, 0) + 1);
            diagMap.put(row - col, diagMap.getOrDefault(row - col, 0) + 1);
            antiDiagMap.put(row + col, antiDiagMap.getOrDefault(row + col, 0) + 1);
        }
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int row = query[0], col = query[1];
            if (rowMap.containsKey(row) || colMap.containsKey(col) || diagMap.containsKey(row - col) || antiDiagMap.containsKey(row + col)) {
                ans[i] = 1;
            }
            for (int r = row - 1; r <= row + 1; r++) {
                for (int c = col - 1; c <= col + 1; c++) {
                    int key = r * n + c;
                    if (lampSet.contains(key)) {
                        lampSet.remove(key);
                        rowMap.put(r, rowMap.get(r) - 1);
                        colMap.put(c, colMap.get(c) - 1);
                        diagMap.put(r - c, diagMap.get(r - c) - 1);
                        antiDiagMap.put(r + c, antiDiagMap.get(r + c) - 1);
                        if (rowMap.get(r) == 0) {
                            rowMap.remove(r);
                        }
                        if (colMap.get(c) == 0) {
                            colMap.remove(c);
                        }
                        if (diagMap.get(r - c) == 0) {
                            diagMap.remove(r -
    }
}