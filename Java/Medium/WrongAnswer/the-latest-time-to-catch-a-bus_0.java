class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int i = 0;
        int j = 0;
        int n = buses.length;
        int m = passengers.length;
        while (i < n && j < m) {
            int wait = 0;
            while (j < m && wait < capacity && passengers[j] <= buses[i]) {
                j++;
                wait++;
            }
            i++;
        }
        return passengers[j - 1];
    }
}