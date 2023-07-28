class Solution {
    public int minMovesToMakePalindrome(String s) {
        
        int n = s.length();
        int[] c = new int[26];
        for (int i = 0; i < n; i++) {
            c[s.charAt(i) - 'a']++;
        }
        int odd = 0;
        for (int i = 0; i < 26; i++) {
            if (c[i] % 2 == 1) {
                odd++;
            }
        }
        if (odd <= 1) {
            return 0;
        }
        int mid = (n - 1) / 2;
        int i = 0;
        int j = n - 1;
        int ans = 0;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                if (s.charAt(i) == s.charAt(mid)) {
                    ans++;
                    for (int k = j; k > mid; k--) {
                        s = s.substring(0, k) + s.charAt(k - 1) + s.substring(k);
                    }
                    j--;
                    mid--;
                } else if (s.charAt(j) == s.charAt(mid)) {
                    ans++;
                    for (int k = i; k < mid; k++) {
                        s = s.substring(0, k) + s.charAt(k + 1) + s.substring(k + 1);
                    }
                    i++;
                    mid--;
                } else {
                    ans += 2;
                    for (int k = j; k > mid; k--) {
                        s = s.substring(0, k) + s.charAt(k - 1) + s.substring(k);
                    }
                    j--;
                    mid--;
                    for (int k = i; k < mid; k++) {
                        s = s.substring(0, k) + s.charAt(k + 1) + s.substring(k + 1);
                    }
                    i++;
                    mid--;
                }
            }
        }
        return ans;
    }
}