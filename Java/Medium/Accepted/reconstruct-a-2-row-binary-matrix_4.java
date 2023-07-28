class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        
        List<List<Integer>> result = new ArrayList<>();
        int n = colsum.length;
        int[] upperRow = new int[n];
        int[] lowerRow = new int[n];
        for (int i = 0; i < n; i++) {
            if (colsum[i] == 2) {
                upperRow[i] = 1;
                lowerRow[i] = 1;
                upper--;
                lower--;
            }
        }
        if (upper < 0 || lower < 0) {
            return result;
        }
        for (int i = 0; i < n; i++) {
            if (colsum[i] == 1) {
                if (upper > 0) {
                    upperRow[i] = 1;
                    upper--;
                } else if (lower > 0) {
                    lowerRow[i] = 1;
                    lower--;
                } else {
                    return result;
                }
            }
        }
        if (upper > 0 || lower > 0) {
            return result;
        }
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            result.get(0).add(upperRow[i]);
            result.get(1).add(lowerRow[i]);
        }
        return result;
    }
}