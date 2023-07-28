class Solution {
    public long appealSum(String s) {
        
        long ans = 0;
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            int[] temp = new int[26];
            for (int j = i; j < n; j++) {
                temp[s.charAt(j) - 'a']++;
                if (temp[s.charAt(j) - 'a'] == 1) {
                    count[s.charAt(j) - 'a']++;
                }
                ans += count[s.charAt(j) - 'a'];
            }
        }
        return ans;
    }
}