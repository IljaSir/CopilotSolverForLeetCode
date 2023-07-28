class Solution {
    public String reorganizeString(String s) {
        
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a'] += 100;
        }
        for (int i = 0; i < 26; i++) {
            count[i] += i;
        }
        Arrays.sort(count);
        char[] res = new char[s.length()];
        int t = 1;
        for (int code : count) {
            int ct = code / 100;
            char ch = (char) ('a' + (code % 100));
            if (ct > (s.length() + 1) / 2) return "";
            for (int i = 0; i < ct; i++) {
                if (t >= s.length()) t = 0;
                res[t] = ch;
                t += 2;
            }
        }
        return String.valueOf(res);
    }
}