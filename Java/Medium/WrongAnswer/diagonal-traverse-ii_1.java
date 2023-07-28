class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        
        int m = nums.size();
        int n = 0;
        for (List<Integer> list : nums) {
            n = Math.max(n, list.size());
        }
        int[] ans = new int[m * n];
        int index = 0;
        for (int i = 0; i < m + n - 1; i++) {
            int r = i < n ? 0 : i - n + 1;
            int c = i < n ? i : n - 1;
            while (r < m && c >= 0) {
                if (nums.get(r).size() > c) {
                    ans[index++] = nums.get(r).get(c);
                }
                r++;
                c--;
            }
        }
        return ans;
    }
}