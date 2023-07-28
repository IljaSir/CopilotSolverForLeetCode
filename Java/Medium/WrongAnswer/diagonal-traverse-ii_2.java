class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        
        int m = nums.size();
        int n = 0;
        for (List<Integer> list : nums) {
            n = Math.max(n, list.size());
        }
        int[] result = new int[m * n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            int p = i;
            int q = j;
            while (p >= 0 && q >= 0) {
                if (p < nums.size() && q < nums.get(p).size()) {
                    result[k++] = nums.get(p).get(q);
                }
                p--;
                q--;
            }
            if (i == m - 1) {
                j++;
            } else {
                i++;
            }
        }
        return result;
    }
}