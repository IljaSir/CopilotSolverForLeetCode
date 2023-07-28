class Solution {
    public String reorganizeString(String s) {
        
        int[] count = new int[26];
        int max = 0;
        int length = s.length();
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
            max = Math.max(max, count[c - 'a']);
        }
        if (max > (length + 1) / 2) {
            return "";
        }
        char[] reorg = new char[length];
        int even = 0, odd = 1;
        int halfLength = length / 2;
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            while (count[i] > 0 && count[i] <= halfLength && odd < length) {
                reorg[odd] = c;
                count[i]--;
                odd += 2;
            }
            while (count[i] > 0) {
                reorg[even] = c;
                count[i]--;
                even += 2;
            }
        }
        return String.valueOf(reorg);
    }
}