class Solution {
    public int bestClosingTime(String customers) {
        
        int penalty = 0;
        int n = customers.length();
        int[] penaltyArray = new int[n];
        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'N') {
                penalty++;
            }
            penaltyArray[i] = penalty;
        }
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'Y') {
                penalty++;
            }
            penalty += penaltyArray[n - 1] - penaltyArray[i];
            if (penalty < min) {
                min = penalty;
                minIndex = i + 1;
            }
        }
        return minIndex;
    }
}