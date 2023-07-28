class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        
        int n = s.length();
        char[] c = s.toCharArray();
        int i = 0;
        for (int j = 0; j < n; ++j) {
            c[i] = c[j];
            if (i == 0 || c[i - 1] != c[i] || i < repeatLimit || c[i - repeatLimit] != c[i]) {
                i++;
            }
        }
        return new String(c, 0, i);
    }
}