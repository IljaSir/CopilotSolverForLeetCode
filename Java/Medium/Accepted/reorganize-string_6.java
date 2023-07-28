class Solution {
    public String reorganizeString(String s) {
        
        int[] count = new int[26];
        int max = 0;
        char[] sc = s.toCharArray();
        for (char c : sc) {
            count[c - 'a']++;
            max = Math.max(max, count[c - 'a']);
        }
        if (max > (sc.length + 1) / 2) {
            return "";
        }
        char[] res = new char[sc.length];
        int even = 0, odd = 1;
        int halfLen = sc.length / 2;
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            while (count[i] > 0 && count[i] <= halfLen && odd < sc.length) {
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
        return String.valueOf(res);
    }
}