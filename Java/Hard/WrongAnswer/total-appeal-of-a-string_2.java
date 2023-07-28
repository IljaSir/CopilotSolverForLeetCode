class Solution {
    public long appealSum(String s) {
        
        int n = s.length();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int[] count = new int[26];
            for (int j = i; j < n; j++) {
                if (count[s.charAt(j) - 'a']++ == 0) {
                    ans += j - i + 1;
                }
            }
        }
        return ans;
    }
}