class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> upperList = new ArrayList<>();
        List<Integer> lowerList = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < colsum.length; i++) {
            sum += colsum[i];
            upperList.add(0);
            lowerList.add(0);
        }
        if (sum != upper + lower) {
            return result;
        }
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2) {
                upperList.set(i, 1);
                lowerList.set(i, 1);
                upper--;
                lower--;
            }
        }
        if (upper < 0 || lower < 0) {
            return result;
        }
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 1) {
                if (upper > 0) {
                    upperList.set(i, 1);
                    upper--;
                } else if (lower > 0) {
                    lowerList.set(i, 1);
                    lower--;
                } else {
                    return result;
                }
            }
        }
        result.add(upperList);
        result.add(lowerList);
        return result;
    }
}