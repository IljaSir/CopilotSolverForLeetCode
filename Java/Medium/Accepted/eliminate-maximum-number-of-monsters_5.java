class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        
        int n = dist.length;
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = (dist[i] + speed[i] - 1) / speed[i];
        }
        Arrays.sort(times);
        int lastTime = 0;
        int result = 0;
        for (int time : times) {
            if (time > lastTime) {
                result++;
                lastTime++;
            } else {
                break;
            }
        }
        return result;
    }
}