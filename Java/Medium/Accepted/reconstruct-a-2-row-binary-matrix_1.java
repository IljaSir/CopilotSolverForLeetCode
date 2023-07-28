class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        
        int n = colsum.length;
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            res.get(0).add(0);
            res.get(1).add(0);
        }
        for (int i = 0; i < n; i++) {
            if (colsum[i] == 2) {
                res.get(0).set(i, 1);
                res.get(1).set(i, 1);
                upper--;
                lower--;
            }
        }
        for (int i = 0; i < n; i++) {
            if (colsum[i] == 1) {
                if (upper > 0) {
                    res.get(0).set(i, 1);
                    upper--;
                } else if (lower > 0) {
                    res.get(1).set(i, 1);
                    lower--;
                } else {
                    return new ArrayList<>();
                }
            }
        }
        if (upper == 0 && lower == 0) {
            return res;
        } else {
            return new ArrayList<>();
        }
    }
}