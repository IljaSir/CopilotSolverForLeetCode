class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        
        int m = nums.size();
        int n = 0;
        for (List<Integer> list : nums) {
            n = Math.max(n, list.size());
        }
        int[] res = new int[m * n];
        int[] idx = new int[m];
        int i = 0;
        boolean up = true;
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                if (up) {
                    int x = k;
                    int y = j - k;
                    if (y >= 0 && y < nums.get(x).size()) {
                        res[i++] = nums.get(x).get(y);
                    }
                } else {
                    int x = m - k - 1;
                    int y = j - (m - k - 1);
                    if (y >= 0 && y < nums.get(x).size()) {
                        res[i++] = nums.get(x).get(y);
                    }
                }
            }
            up = !up;
        }
        return res;
    }
}