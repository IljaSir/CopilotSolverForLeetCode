class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        int r = reservedSeats.length;
        int[][] seats = new int[n][10];
        for (int i = 0; i < r; i++) {
            int[] seat = reservedSeats[i];
            seats[seat[0] - 1][seat[1] - 1] = 1;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            int[] seat = seats[i];
            if (seat[0] == 0 && seat[1] == 0 && seat[2] == 0 && seat[3] == 0) {
                result++;
                seat[0] = 1;
                seat[1] = 1;
                seat[2] = 1;
                seat[3] = 1;
            }
            if (seat[1] == 0 && seat[2] == 0 && seat[3] == 0 && seat[4] == 0) {
                result++;
                seat[1] = 1;
                seat[2] = 1;
                seat[3] = 1;
                seat[4] = 1;
            }
            if (seat[3] == 0 && seat[4] == 0 && seat[5] == 0 && seat[6] == 0) {
                result++;
                seat[3] = 1;
                seat[4] = 1;
                seat[5] = 1;
                seat[6] = 1;
            }
            if (seat[5] == 0 && seat[6] == 0 && seat[7] == 0 && seat[8] == 0) {
                result++;
                seat[5] = 1;
                seat[6] = 1;
                seat[7] = 1;
                seat[8] = 1;
            }
            if (seat[7] == 0 && seat[8] == 0 && seat[9] == 0 && seat[10] == 0) {
                result++;
                seat[7] = 1;
                seat[8] = 1;
                seat[9] = 1;
                seat[10] = 1;
            }
        }
        return result;
    }
}