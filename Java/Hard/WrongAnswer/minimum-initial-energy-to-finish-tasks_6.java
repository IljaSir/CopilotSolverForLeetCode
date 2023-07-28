class Solution {
    public int minimumEffort(int[][] tasks) {
        
        Arrays.sort(tasks, (a, b) -> a[1] - a[0] - b[1] + b[0]);
        int ans = 0, cur = 0;
        for (int[] t : tasks) {
            ans += Math.max(t[1] - cur, 0);
            cur = Math.max(cur + t[0], t[1]);
        }
        return ans;
    }
}