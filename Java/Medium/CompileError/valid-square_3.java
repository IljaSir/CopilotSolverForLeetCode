class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        
        int[] dist = new int[6];
        dist[0] = dist(p1, p2);
        dist[1] = dist(p1, p3);
        dist[2] = dist(p1, p4);
        dist[3] = dist(p2, p3);
        dist[4] = dist(p2, p4);
        dist[5] = dist(p3, p4);
        Arrays.sort(dist);
        return dist[0] > 0 && dist[0] == dist[1] && dist[1] == dist[2] && dist[2] == dist[3] && dist[4] == dist[5];
    }
}