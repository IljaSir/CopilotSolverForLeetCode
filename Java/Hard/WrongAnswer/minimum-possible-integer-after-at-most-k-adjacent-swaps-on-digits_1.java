class Solution {
    public String minInteger(String num, int k) {
        
        int n = num.length();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = num.charAt(i) - '0';
        }
        int[] pos = new int[10];
        for (int i = 0; i < 10; ++i) {
            pos[i] = -1;
        }
        for (int i = 0; i < n; ++i) {
            int x = a[i];
            for (int d = 0; d < x; ++d) {
                if (pos[d] >= 0 && i - pos[d] <= k) {
                    for (int j = pos[d]; j < i; ++j) {
                        a[j] = a[j + 1];
                        --k;
                    }
                    a[i] = d;
                    break;
                }
            }
            pos[x] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            sb.append((char) (a[i] + '0'));
        }
        return sb.toString();
    }
}