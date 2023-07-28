class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int n = buses.length;
        int m = passengers.length;
        int i = 0;
        int j = 0;
        int count = 0;
        int max = 0;
        while (i < n && j < m) {
            if (buses[i] < passengers[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            if (count == capacity) {
                max = Math.max(max, passengers[j - 1]);
            }
        }
        return max;
    }
}