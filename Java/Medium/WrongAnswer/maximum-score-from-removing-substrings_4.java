class Solution {
    public int maximumGain(String s, int x, int y) {
        
        int a = 0, b = 0;
        int count = 0;
        if (x > y) {
            for (char c : s.toCharArray()) {
                if (c == 'a') {
                    a++;
                } else if (c == 'b') {
                    if (a > 0) {
                        a--;
                        count += x;
                    } else {
                        b++;
                    }
                } else {
                    count += a;
                    a = 0;
                    count += b;
                    b = 0;
                }
            }
            count += a;
            count += b;
            a = 0;
            b = 0;
            for (char c : s.toCharArray()) {
                if (c == 'b') {
                    b++;
                } else if (c == 'a') {
                    if (b > 0) {
                        b--;
                        count += y;
                    } else {
                        a++;
                    }
                } else {
                    count += a;
                    a = 0;
                    count += b;
                    b = 0;
                }
            }
            count += a;
            count += b;
        } else {
            for (char c : s.toCharArray()) {
                if (c == 'b') {
                    b++;
                } else if (c == 'a') {
                    if (b > 0) {
                        b--;
                        count += y;
                    } else {
                        a++;
                    }
                } else {
                    count += a;
                    a = 0;
                    count += b;
                    b = 0;
                }
            }
            count += a;
            count += b;
            a = 0;
            b = 0;
            for (char c : s.toCharArray()) {
                if (c == 'a') {
                    a++;
                } else if (c == 'b') {
                    if (a > 0) {
                        a--;
                        count += x;
                    } else {
                        b++;
                    }
                } else {
                    count += a;
                    a = 0;
                    count += b;
                    b = 0;
                }
            }
            count += a;
            count += b;
        }
        return count;
    }
}