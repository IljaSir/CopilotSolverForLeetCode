class Solution {
    public int numTeams(int[] rating) {
        
        int total = 0;
        for (int i = 1; i < rating.length - 1; i++) {
            int leftLess = 0, leftMore = 0, rightLess = 0, rightMore = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    leftLess++;
                } else {
                    leftMore++;
                }
            }
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[j] < rating[i]) {
                    rightLess++;
                } else {
                    rightMore++;
                }
            }
            total += leftLess * rightMore + leftMore * rightLess;
        }
        return total;
    }
}