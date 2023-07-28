class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        
        int n = edges.length;
        int[] distFromNode1 = new int[n];
        int[] distFromNode2 = new int[n];
        Arrays.fill(distFromNode1, -1);
        Arrays.fill(distFromNode2, -1);
        distFromNode1[node1] = 0;
        distFromNode2[node2] = 0;
        int maxDist = Integer.MAX_VALUE;
        int minNode = -1;
        for (int i = 0; i < n; i++) {
            if (distFromNode1[i] != -1) {
                int j = i;
                while (edges[j] != -1 && distFromNode1[edges[j]] == -1) {
                    j = edges[j];
                    distFromNode1[j] = distFromNode1[i] + 1;
                }
            }
            if (distFromNode2[i] != -1) {
                int j = i;
                while (edges[j] != -1 && distFromNode2[edges[j]] == -1) {
                    j = edges[j];
                    distFromNode2[j] = distFromNode2[i] + 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (distFromNode1[i] != -1 && distFromNode2[i] != -1) {
                int max = Math.max(distFromNode1[i], distFromNode2[i]);
                if (max < maxDist) {
                    maxDist = max;
                    minNode = i;
                }
            }
        }
        return minNode;
    }
}