class Solution {
    public int numTeams(int[] rating) {
        
        int n = rating.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (rating[i] < rating[j] && rating[j] < rating[k]) {
                        res++;
                    }
                    if (rating[i] > rating[j] && rating[j] > rating[k]) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}