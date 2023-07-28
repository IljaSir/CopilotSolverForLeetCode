class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int i = 0;
        int j = 0;
        int result = 0;
        while (i < buses.length && j < passengers.length) {
            int count = 0;
            while (j < passengers.length && passengers[j] <= buses[i] && count < capacity) {
                j++;
                count++;
            }
            if (count > 0) {
                result = buses[i];
            }
            i++;
        }
        return result;
    }
}