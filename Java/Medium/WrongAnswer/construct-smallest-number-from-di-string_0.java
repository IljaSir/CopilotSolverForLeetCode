class Solution {
    public String smallestNumber(String pattern) {
        
        int n = pattern.length();
        int[] res = new int[n + 1];
        int left = 0;
        int right = n;
        for (int i = 0; i < n; i++) {
            if (pattern.charAt(i) == 'I') {
                res[i] = left++;
            } else {
                res[i] = right--;
            }
        }
        res[n] = left;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n + 1; i++) {
            sb.append(res[i]);
        }
        return sb.toString();
    }
}