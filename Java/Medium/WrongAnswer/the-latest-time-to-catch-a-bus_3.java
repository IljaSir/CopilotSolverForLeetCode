class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int i = 0, j = 0, n = buses.length, m = passengers.length;
        while (i < n && j < m) {
            int bus = buses[i];
            int count = 0;
            while (j < m && passengers[j] <= bus && count < capacity) {
                count++;
                j++;
            }
            i++;
        }
        return j == m ? passengers[j - 1] : -1;
    }
}