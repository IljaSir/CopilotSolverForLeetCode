class Solution {
public:
    int maximumGain(string s, int x, int y) {
        
        int ans = 0;
        if (x < y) {
            swap(x, y);
            for (auto& c : s) {
                if (c == 'a') c = 'b';
                else if (c == 'b') c = 'a';
            }
        }
        int a = 0, b = 0;
        for (auto c : s) {
            if (c == 'a') ++a;
            else if (c == 'b') {
                if (a > 0) {
                    --a;
                    ans += x;
                } else ++b;
            } else {
                ans += min(a, b) * y;
                a = b = 0;
            }
        }
        ans += min(a, b) * y;
        return ans;
    }
};