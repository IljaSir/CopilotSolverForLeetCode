class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int n = gas.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = gas[i] - cost[i];
        }
        int i = 0;
        while (i < n) {
            int sum = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sum += diff[j];
                if (sum < 0) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }
}