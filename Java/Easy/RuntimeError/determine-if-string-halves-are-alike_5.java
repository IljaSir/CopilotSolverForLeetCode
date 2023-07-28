class Solution {
    public boolean halvesAreAlike(String s) {
        
        int[] c = new int[26];
        c['a' - 'a'] = 1;
        c['e' - 'a'] = 1;
        c['i' - 'a'] = 1;
        c['o' - 'a'] = 1;
        c['u' - 'a'] = 1;
        c['A' - 'a'] = 1;
        c['E' - 'a'] = 1;
        c['I' - 'a'] = 1;
        c['O' - 'a'] = 1;
        c['U' - 'a'] = 1;
        
        int n = s.length();
        int l = 0, r = 0;
        for (int i = 0; i < n / 2; i++) {
            l += c[s.charAt(i) - 'a'];
        }
        for (int i = n / 2; i < n; i++) {
            r += c[s.charAt(i) - 'a'];
        }
        return l == r;
    }
}