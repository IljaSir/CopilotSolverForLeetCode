class Solution {
    public String reorganizeString(String s) {
        
        int[] count = new int[26];
        int max = 0;
        int maxChar = 0;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            if (count[s.charAt(i) - 'a'] > max) {
                max = count[s.charAt(i) - 'a'];
                maxChar = s.charAt(i) - 'a';
            }
        }
        if (max > (s.length() + 1) / 2) {
            return "";
        }
        char[] res = new char[s.length()];
        int idx = 0;
        while (count[maxChar] > 0) {
            res[idx] = (char) (maxChar + 'a');
            idx += 2;
            count[maxChar]--;
        }
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                if (idx >= s.length()) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                count[i]--;
            }
        }
        return new String(res);
    }
}