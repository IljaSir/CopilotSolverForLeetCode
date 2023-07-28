class Solution {
    public String minWindow(String s, String t) {
        
        int[] count = new int[128];
        for (char c : t.toCharArray()) {
            count[c]++;
        }
        int left = 0;
        int right = 0;
        int minLeft = 0;
        int minLen = Integer.MAX_VALUE;
        int countT = t.length();
        while (right < s.length()) {
            char c = s.charAt(right);
            if (count[c] > 0) {
                countT--;
            }
            count[c]--;
            right++;
            while (countT == 0) {
                if (right - left < minLen) {
                    minLeft = left;
                    minLen = right - left;
                }
                char c2 = s.charAt(left);
                if (count[c2] == 0) {
                    countT++;
                }
                count[c2]++;
                left++;
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(minLeft, minLeft + minLen);
        }
    }
}