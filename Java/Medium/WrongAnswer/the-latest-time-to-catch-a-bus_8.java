class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        
        int n = buses.length;
        int m = passengers.length;
        Arrays.sort(passengers);
        Arrays.sort(buses);
        int i = 0;
        int j = 0;
        int count = 0;
        int res = 0;
        while(i < n && j < m) {
            while(j < m && passengers[j] <= buses[i]) {
                count++;
                j++;
            }
            if(count >= capacity) {
                res = buses[i];
                count -= capacity;
            } else {
                res = passengers[j - 1];
                count = 0;
            }
            i++;
        }
        return res;
    }
}