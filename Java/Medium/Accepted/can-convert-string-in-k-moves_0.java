class Solution {
    public boolean canConvertString(String s, String t, int k) {
        
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int diff = (t.charAt(i) - s.charAt(i) + 26) % 26;
            if (diff != 0) {
                count[diff]++;
                if (count[diff] > k / 26 + (k % 26 >= diff ? 1 : 0)) {
                    return false;
                }
            }
        }
        return true;
    }
}