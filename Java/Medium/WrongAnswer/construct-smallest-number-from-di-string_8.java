class Solution {
    public String smallestNumber(String pattern) {
        
        int n = pattern.length();
        int[] nums = new int[n+1];
        for (int i = 0; i <= n; i++) {
            nums[i] = i;
        }
        int[] res = new int[n+1];
        int start = 0;
        int end = n;
        for (int i = 0; i < n; i++) {
            if (pattern.charAt(i) == 'I') {
                res[i] = nums[start];
                start++;
            } else {
                res[i] = nums[end];
                end--;
            }
        }
        res[n] = nums[start];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            sb.append(res[i]);
        }
        return sb.toString();
    }
}