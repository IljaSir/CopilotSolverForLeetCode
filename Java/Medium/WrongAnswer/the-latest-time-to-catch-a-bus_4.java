class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int i = 0, j = 0;
        int res = 0;
        while (i < buses.length && j < passengers.length) {
            int count = 0;
            while (j < passengers.length && count < capacity && passengers[j] <= buses[i]) {
                count++;
                j++;
            }
            res = buses[i];
            i++;
        }
        return res;
    }
}