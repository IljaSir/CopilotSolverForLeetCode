class Solution {
    public String minWindow(String s, String t) {
        
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        int[] tCount = new int[128];
        for (char c : t.toCharArray()) {
            tCount[c]++;
        }

        int[] sCount = new int[128];
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            if (tCount[s.charAt(end)] == 0) {
                continue;
            }

            sCount[s.charAt(end)]++;
            if (sCount[s.charAt(end)] <= tCount[s.charAt(end)]) {
                count++;tart + minLen);
    }
}