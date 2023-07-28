class Solution {
    public int bestClosingTime(String customers) {
        
        int n = customers.length();
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (customers.charAt(i) == 'Y' ? 1 : 0);
        }
        int ans = 0;
        int min = prefix[n];
        for (int i = 0; i < n; i++) {
            int penalty = prefix[i + 1] + (prefix[n] - prefix[i + 1]) * 2;
            if (penalty < min) {
                min = penalty;
                ans = i + 1;
            }
        }
        return ans;
    }
}