class Solution {
    public String smallestNumber(String pattern) {
        
        int n = pattern.length();
        int[] ans = new int[n + 1];
        int min = 1;
        int max = n + 1;
        for (int i = 0; i < n; i++) {
            if (pattern.charAt(i) == 'I') {
                ans[i] = min++;
            } else {
                ans[i] = max--;
            }
        }
        ans[n] = min;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            sb.append(ans[i]);
        }
        return sb.toString();
    }
}