class Solution {
    public boolean canConstruct(String s, int k) {
        
        if (s.length() < k) return false;
        if (s.length() == k) return true;
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        int odd = 0;
        for (int i : count) {
            if (i % 2 == 1) odd++;
        }
        return odd <= k;
    }
}