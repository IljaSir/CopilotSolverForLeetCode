class Solution {
    public int numTeams(int[] rating) {
        
        int n = rating.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (rating[j] < rating[i]) {
                    left[i]++;
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (rating[j] < rating[i]) {
                    right[i]++;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (rating[i] < rating[j]) {
                    count += left[j];
                } else {
                    count += right[j];
                }
            }
        }
        return count;
    }
}