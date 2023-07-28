class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        
        int n = buses.length;
        int m = passengers.length;
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int ans = -1;
        int j = 0;
        for (int i = 0; i < n; i++) {
            int bus = buses[i];
            int count = 0;
            while (j < m && passengers[j] <= bus && count < capacity) {
                ans = Math.max(ans, passengers[j]);
                j++;
                count++;
            }
        }
        return ans;
    }
}