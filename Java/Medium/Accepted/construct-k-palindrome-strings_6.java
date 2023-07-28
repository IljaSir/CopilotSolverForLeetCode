class Solution {
    public boolean canConstruct(String s, int k) {
        
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        int odd = 0;
        for (int i = 0; i < 26; i++) {
            if (counts[i] % 2 == 1) {
                odd++;
            }
        }
        return odd <= k && k <= s.length();
    }
}