class Solution {
    public int[] diStringMatch(String s) {
        
        int n = s.length();
        int[] ans = new int[n + 1];
        int left = 0, right = n;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                ans[i] = left++;
            } else {
                ans[i] = right--;
            }
        }
        ans[n] = left;
        return ans;
    }
}