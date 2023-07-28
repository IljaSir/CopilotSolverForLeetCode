class Solution {
    public int[] getCoprimes(int[] nums, int[][] edges) {
        
        int n = nums.length;
        int[] p = new int[n];
        Arrays.fill(p, -1);
        for (int[] e : edges) {
            if (p[e[1]] == -1) p[e[1]] = e[0];
            else p[e[0]] = e[1];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int x = i;
            int y = nums[i];
            int d = 0;
            while (x != -1) {
                if (gcd(y, nums[x]) == 1) {
                    ans[i] = x;
                    break;
                }
                x = p[x];
                d++;
            }
            if (x == -1) ans[i] = -1;
        }
        return ans;
    }
}