class Solution {
    public String reorganizeString(String s) {
        
        // count the frequency of each character
        int[] count = new int[26];
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            count[c - 'a']++;
            max = Math.max(max, count[c - 'a']);
        }
        // if the max frequency is larger than (len + 1) / 2, it is impossible to satisfy the requirement
        if (max > (len + 1) / 2) {
            return "";
        }
        // build the result string
        char[] res = new char[len];
        int even = 0, odd = 1;
        int halfLen = len / 2;
        for (int i = 0; i < 26; i++) {
            char c = (char)('a' + i);
            while (count[i] > 0 && count[i] <= halfLen && odd < len) {
                res[odd] = c;
                count[i]--;
                odd += 2;
            }
            while (count[i] > 0) {
                res[even] = c;
                count[i]--;
                even += 2;
            }
        }
        return new String(res);
    }
}