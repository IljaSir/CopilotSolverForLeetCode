class Solution {
    public String smallestNumber(String pattern) {
        
        int n = pattern.length();
        int[] res = new int[n+1];
        int i = 0;
        int max = n;
        int min = 1;
        while (i < n) {
            if (pattern.charAt(i) == 'I') {
                res[i] = min++;
            } else {
                res[i] = max--;
            }
            i++;
        }
        res[i] = min;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j <= n; j++) {
            sb.append(res[j]);
        }
        return sb.toString();
    }
}