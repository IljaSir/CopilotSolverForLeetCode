class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2) {
                upper--;
                lower--;
                result.get(0).add(1);
                result.get(1).add(1);
            } else {
                result.get(0).add(0);
                result.get(1).add(0);
            }
        }
        if (upper < 0 || lower < 0) {
            return new ArrayList<>();
        }
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 1) {
                if (upper > 0) {
                    upper--;
                    result.get(0).set(i, 1);
                } else {
                    lower--;
                    result.get(1).set(i, 1);
                }
            }
        }
        if (upper > 0 || lower > 0) {
            return new ArrayList<>();
        }
        return result;
    }
}