class Solution {
    public String minInteger(String num, int k) {
        
        int[] count = new int[10];
        int n = num.length();
        char[] s = num.toCharArray();
        for (int i = 0; i < n; ++i) {
            ++count[s[i] - '0'];
            for (int d = 0; d < 10; ++d) {
                if (count[d] == 0) continue;
                int need = (s[i] - '0' - d) * count[d];
                if (need <= k) {
                    k -= need;
                    for (int j = i - 1; j >= 0 && s[j] - '0' != d; --j) {
                        --count[s[j] - '0'];
                        s[j + 1] = s[j];
                    }
                    s[i - count[d] + 1] = (char) ('0' + d);
                    break;
                }
            }
        }
        return new String(s);
    }
}