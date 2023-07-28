class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return res;
        }
        int[] count = new int[26];
        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }
        int left = 0;
        int right = 0;
        int len = p.length();
        while (right < s.length()) {
            count[s.charAt(right) - 'a']--;
            if (right - left + 1 == len) {
                if (allZero(count)) {
                    res.add(left);
                }
                count[s.charAt(left) - 'a']++;
                left++;
            }
            right++;
        }
        return res;
    }
    private boolean allZero(int[] count) {
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}