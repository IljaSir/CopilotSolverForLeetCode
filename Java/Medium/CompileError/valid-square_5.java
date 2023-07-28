class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        
        int[] d = new int[6];
        d[0] = getDistance(p1, p2);
        d[1] = getDistance(p1, p3);
        d[2] = getDistance(p1, p4);
        d[3] = getDistance(p2, p3);
        d[4] = getDistance(p2, p4);
        d[5] = getDistance(p3, p4);
        Arrays.sort(d);
        return d[0] > 0 && d[0] == d[1] && d[1] == d[2] && d[2] == d[3] && d[4] == d[5];
    }
}