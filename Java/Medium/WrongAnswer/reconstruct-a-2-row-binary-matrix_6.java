class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        
        List<List<Integer>> res = new ArrayList<>();
        int[] row = new int[2];
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2) {
                row[0]++;
                row[1]++;
            } else if (colsum[i] == 1) {
                if (row[0] < upper) {
                    row[0]++;
                } else {
                    row[1]++;
                }
            }
        }
        if (row[0] != upper || row[1] != lower) {
            return res;
        }
        List<Integer> row1 = new ArrayList<>();
        List<Integer> row2 = new ArrayList<>();
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2) {
                row1.add(1);
                row2.add(1);
            } else if (colsum[i] == 1) {
                if (row[0] < upper) {
                    row1.add(1);
                    row2.add(0);
                    row[0]++;
                } else {
                    row1.add(0);
                    row2.add(1);
                    row[1]++;
                }
            } else {
                row1.add(0);
                row2.add(0);
            }
        }
        res.add(row1);
        res.add(row2);
        return res;
    }
}