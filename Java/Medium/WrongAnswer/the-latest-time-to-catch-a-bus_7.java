class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        
        int n = buses.length;
        int m = passengers.length;
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int i = 0;
        int j = 0;
        int ans = 0;
        for (int k = 0; k < m; k++) {
            if (i < n && buses[i] <= passengers[k]) {
                i++;
            } else {
                j++;
            }
            if (j == capacity) {
                j = 0;
                i--;
            }
            ans = Math.max(ans, passengers[k]);
        }
        return ans;
    }
}