class Solution {
    public int arrayNesting(int[] nums) {
        
        int n = nums.length;
        boolean[] visited = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int start = nums[i], count = 0;
                do {
                    start = nums[start];
                    count++;
                    visited[start] = true;
                } while (start != nums[i]);
                res = Math.max(res, count);
            }
        }
        return res;
    }
}