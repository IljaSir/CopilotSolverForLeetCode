class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        
        int n = colsum.length;
        int[] row1 = new int[n];
        int[] row2 = new int[n];
        for (int i = 0; i < n; i++) {
            if (colsum[i] == 2) {
                row1[i] = 1;
                row2[i] = 1;
                upper--;
                lower--;
            }
        }
        for (int i = 0; i < n; i++) {
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
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list1.add(row1[i]);
            list2.add(row2[i]);
        }
        res.add(list1);
        res.add(list2);
        return res;
    }
}