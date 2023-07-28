class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        
        int[] row = new int[2];
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2) {
                row[0]++;
                row[1]++;
            }
        }
        if (row[0] > upper || row[1] > lower) {
            return res;
        }
        upper -= row[0];
        lower -= row[1];
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 1) {
                if (upper > 0) {
                    row[0]++;
                    upper--;
                } else {
                    row[1]++;
                    lower--;
                }
            }
        }
        if (upper != 0 || lower != 0) {
            return res;
        }
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 0) {
                l1.add(0);
                l2.add(0);
            } else if (colsum[i] == 1) {
                if (row[0] > 0) {
                    l1.add(1);
                    l2.add(0);
                    row[0]--;
                } else {
                    l1.add(0);
                    l2.add(1);
                    row[1]--;
                }
            } else {
                l1.add(1);
                l2.add(1);
            }
        }
        res.add(l1);
        res.add(l2);
        return res;
    }
}