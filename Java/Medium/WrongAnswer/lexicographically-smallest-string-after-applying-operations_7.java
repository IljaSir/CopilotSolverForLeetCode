class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        
        String ans = s;
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j += 2) {
                chars[j] = (char) ((chars[j] - '0' + a) % 10 + '0');
            }
            s = new String(chars);
            ans = ans.compareTo(s) > 0 ? s : ans;
        }
        for (int i = 0; i < n; i++) {
            s = s.substring(n - b) + s.substring(0, n - b);
            ans = ans.compareTo(s) > 0 ? s : ans;
        }
        return ans;
    }
}