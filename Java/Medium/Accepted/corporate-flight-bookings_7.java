class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        
        int[] res = new int[n];
        for (int[] booking : bookings) {
            int first = booking[0] - 1;
            int last = booking[1] - 1;
            int seats = booking[2];
            res[first] += seats;
            if (last + 1 < n) {
                res[last + 1] -= seats;
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += res[i];
            res[i] = sum;
        }
        return res;
    }
}