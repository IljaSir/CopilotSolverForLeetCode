class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        
        int n = dist.length;
        int[] timeToReach = new int[n];
        for (int i = 0; i < n; i++) {
            timeToReach[i] = (int)Math.ceil((double)dist[i] / speed[i]);
        }
        Arrays.sort(timeToReach);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (timeToReach[i] > ans) {
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }
}