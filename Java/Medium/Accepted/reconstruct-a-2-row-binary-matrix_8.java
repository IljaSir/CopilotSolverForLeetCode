class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        
        List<List<Integer>> result = new ArrayList<>();
        int[] row1 = new int[colsum.length];
        int[] row2 = new int[colsum.length];
        int sum = upper + lower;
        for (int i = 0; i < colsum.length; i++) {
            sum -= colsum[i];
        }
        if (sum != 0) {
            return result;
        }
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2) {
                row1[i] = 1;
                row2[i] = 1;
                upper--;
                lower--;
            }
        }
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 1) {
                if (upper > 0) {
                    row1[i] = 1;
                    upper--;
                } else {
                    row2[i] = 1;
                    lower--;
                }
            }
        }
        if (upper != 0 || lower != 0) {
            return result;
        }
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < row1.length; i++) {
            list1.add(row1[i]);
        }
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < row2.length; i++) {
            list2.add(row2[i]);
        }
        result.add(list1);
        result.add(list2);
        return result;
    }
}