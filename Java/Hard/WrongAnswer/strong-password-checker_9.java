class Solution {
    public int strongPasswordChecker(String password) {
        
        int len = password.length();
        int ans = 0;
        int[] arr = new int[3];
        int[] rep = new int[len];
        int i = 0;
        int cnt = 0;
        while (i < len) {
            char c = password.charAt(i);
            if (Character.isLowerCase(c)) {
                arr[0] = 1;
            } else if (Character.isUpperCase(c)) {
                arr[1] = 1;
            } else if (Character.isDigit(c)) {
                arr[2] = 1;
            }
            cnt++;
            if (i == len - 1 || password.charAt(i + 1) != c) {
                ans += cnt / 3;
                rep[i] = cnt;
                cnt = 0;
            }
            i++;
        }
        int missing = 3 - (arr[0] + arr[1] + arr[2]);
        if (len < 6) {
            return Math.max(missing, 6 - len);
        } else if (len <= 20) {
            return Math.max(missing, ans);
        } else {
            int del = len - 20;
            ans -= Math.min(del, ans);
            for (int j = 0; j < len && del > 0; j++) {
                if (rep[j] >= 3 && rep[j] % 3 == 0) {
                    rep[j] -= Math.min(del, 2);
                    del -= 2;
                }
            }
            for (int j = 0; j < len && del > 0; j++) {
                if (rep[j] >= 3 && rep[j] % 3 == 1) {
                    rep[j] -= Math.min(del, 1);
                    del -= 1;
                }
            }
            for (int j = 0; j < len && del > 0; j++) {
                if (rep[j] >= 3 && rep[j] % 3 == 2) {
                    rep[j] -= Math.min(del, 1);
                    del -= 1;
                }
            }
            ans += del;
            return del + Math.max(missing, ans);
        }
    }
}