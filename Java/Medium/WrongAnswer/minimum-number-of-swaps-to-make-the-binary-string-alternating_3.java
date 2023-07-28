class Solution {
    public int minSwaps(String s) {
        
        int n = s.length();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.charAt(i) - '0';
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = i % 2;
        }
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = 1 - i % 2;
        }
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = i % 2;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 2; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) {
                    if (a[j] != b[j]) {
                        cnt++;
                    }
                } else {
                    if (a[j] != c[j]) {
                        cnt++;
                    }
                }
            }
            ans = Math.min(ans, cnt / 2);
            int[] t = b;
            b = c;
            c = t;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}