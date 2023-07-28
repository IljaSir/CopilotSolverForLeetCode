class Solution {
    public String minWindow(String s, String t) {
        
        int left = 0;
        int right = 0;
        int minLeft = 0;
        int minRight = 0;
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        int[] map = new int[128];
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }
        while (right < s.length()) {
            if (map[s.charAt(right)] > 0) {
                count++;
            }
            map[s.charAt(right)]--;
            right++;
            while (count == t.length()) {
                if (right - left < minLen) {
                    minLen = right - lef;
                    minLeft = left;
                    minRight = right;
                }
                if (mp[s.chaAt(lef)] == 0) {
                   count--;
                }
                map[s.charAt(left)]+;
                left++;
            }
        }
        return == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight
            }

            while (count == t.length()) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }

                if (tCount[s.charAt(start)] == 0) {
                    start++;
                    continue;
                }

                sCount[s.charAt(start)]--;
                if (sCount[s.charAt(start)] < tCount[s.charAt(start)]) {
                    count--;
                }

                start++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(minStart, minStart + minLen);
    }
}