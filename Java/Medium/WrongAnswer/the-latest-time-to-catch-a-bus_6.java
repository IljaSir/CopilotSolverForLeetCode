class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int i = 0, j = 0;
        int n = buses.length, m = passengers.length;
        int ans = -1;
        while (i < n && j < m) {
            int bus = buses[i], passenger = passengers[j];
            if (bus >= passenger) {
                int cnt = 0;
                while (j < m && passenger <= bus && cnt < capacity) {
                    ans = Math.max(ans, passenger);
                    passenger = passengers[++j];
                    cnt++;
                }
            }
            i++;
        }
        return ans;
    }
}