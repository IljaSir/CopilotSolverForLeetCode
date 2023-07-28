class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        
        int n = edges.length;
        int[] p1 = new int[n];
        int[] p2 = new int[n];
        Arrays.fill(p1, -1);
        Arrays.fill(p2, -1);
        p1[0] = 0;
        p2[0] = 0;
        int i = 0;
        while (i < n) {
            if (p1[i] == -1 && edges[i] != -1) {
                p1[i] = p1[edges[i]] + 1;
            }
            if (p2[i] == -1 && edges[i] != -1) {
                p2[i] = p2[edges[i]] + 1;
            }
            i++;
        }
        int min = Integer.MAX_VALUE;
        int res = -1;
        for (int j = 0; j < n; j++) {
            if (p1[j] != -1 && p2[j] != -1) {
                int max = Math.max(p1[j], p2[j]);
                if (max < min) {
                    min = max;
                    res = j;
                }
            }
        }
        return res;
    }
}