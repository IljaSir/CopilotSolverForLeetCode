class Solution {
    public boolean sumGame(String num) {
        
        int n = num.length();
        int a = 0, b = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (num.charAt(i) == '?') {
                if (i < n / 2) {
                    a++;
                } else {
                    b++;
                }
                cnt++;
            }
        }
        if (cnt % 2 == 1) {
            return true;
        }
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            if (num.charAt(i) == '?') {
                if (i < n / 2) {
                    if (a > b) {
                        x += 9;
                        a--;
                    } else {
                        y += 9;
                        b--;
                    }
                } else {
                    if (a > b) {
                        y += 9;
                        a--;
                    } else {
                        x += 9;
                        b--;
                    }
                }
            } else {
                if (i < n / 2) {
                    x += num.charAt(i) - '0';
                } else {
                    y += num.charAt(i) - '0';
                }
            }
        }
        return x != y;
    }
}