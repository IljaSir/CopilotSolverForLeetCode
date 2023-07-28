class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        if (position.length == 0) {
            return 0;
        }
        int[] time = new int[position.length];
        for (int i = 0; i < position.length; i++) {
            time[i] = (target - position[i]) / speed[i];
        }
        int ans = 1;
        int maxTime = time[0];
        for (int i = 1; i < time.length; i++) {
            if (time[i] > maxTime) {
                ans++;
                maxTime = time[i];
            }
        }
        return ans;
    }
}