class Solution {
public:
    int maximumGain(string s, int x, int y) {
        
        int ans = 0;
        int a = 0;
        int b = 0;
        if (x > y) {
            swap(x, y);
            for (auto c: s) {
                if (c == 'a') {
                    a++;
                } else if (c == 'b') {
                    if (a > 0) {
                        ans += x;
                        a--;
                    } else {
                        b++;
                    }
                } else {
                    ans += min(a, b) * y;
                    a = 0;
                    b = 0;
                }
            }
            ans += min(a, b) * y;
        } else {
            for (auto c: s) {
                if (c == 'b') {
                    b++;
                } else if (c == 'a') {
                    if (b > 0) {
                        ans += y;
                        b--;
                    } else {
                        a++;
                    }
                } else {
                    ans += min(a, b) * x;
                    a = 0;
                    b = 0;
                }
            }
            ans += min(a, b) * x;
        }
        return ans;
    }
};