class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        
        int n = dist.length;
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = (int) Math.ceil((double) dist[i] / speed[i]);
        }
        Arrays.sort(t);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (t[i] <= i) {
                break;
            }
            count++;
        }
        return count;
    }
}