class Solution {
    public String smallestNumber(String pattern) {
        
        int n = pattern.length();
        int[] num = new int[n + 1];
        int low = 1, high = n + 1;
        for (int i = 0; i < n; i++) {
            if (pattern.charAt(i) == 'I') {
                num[i] = low;
                low++;
            } else {
                num[i] = high;
                high--;
            }
        }
        num[n] = low;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            sb.append(num[i]);
        }
        return sb.toString();
    }
}