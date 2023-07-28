class Solution {
    public String smallestNumber(String pattern) {
        
        int n = pattern.length();
        int[] res = new int[n+1];
        int small = 0;
        int big = n;
        for (int i = 0; i < n; i++) {
            if (pattern.charAt(i) == 'I') {
                res[i] = small;
                small++;
            } else {
                res[i] = big;
                big--;
            }
        }
        res[n] = small;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            sb.append(res[i]);
        }
        return sb.toString();
    }
}