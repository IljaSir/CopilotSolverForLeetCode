class Solution {
    public int longestCycle(int[] edges) {
        
        int n = edges.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int slow = i, fast = i;
            while (edges[slow] != -1 && edges[fast] != -1 && edges[fast = edges[fast]] != -1) {
                slow = edges[slow];
                if (slow == fast) {
                    int cur = 1;
                    while (slow != edges[fast]) {
                        cur++;
                        fast = edges[fast];
                    }
                    res = Math.max(res, cur);
                    break;
                }
            }
        }
        return res == 1 ? -1 : res;
    }
}