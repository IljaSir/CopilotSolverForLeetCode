class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int[] count = new int[26];
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }
        int left = 0;
        int right = 0;
        int n = s2.length();
        int m = s1.length();
        int diff = m;
        while (right < n) {
            if (count[s2.charAt(right)-'a'] > 0) {
                diff--;
            }
            count[s2.charAt(right)-'a']--;
            right++;
            if (diff == 0) {
                return true;
            }
            if (right - left == m) {
                if (count[s2.charAt(left)-'a'] >= 0) {
                    diff++;
                }
                count[s2.charAt(left)-'a']++;
                left++;
            }
        }
        return false;
    }
}