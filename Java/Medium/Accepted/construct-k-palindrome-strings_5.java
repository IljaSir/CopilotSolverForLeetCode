class Solution {
    public boolean canConstruct(String s, int k) {
        
        if (k > s.length()) return false;
        if (k == s.length()) return true;
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int odd = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 == 1) odd++;
        }
        return odd <= k;
    }
}