class Solution {
public:
    int maximumGain(string s, int x, int y) {
        
        int res = 0;
        string ab = "ab", ba = "ba";
        if (y > x) {
            swap(ab, ba);
            swap(x, y);
        }
        for (int i = 0; i < 2; i++) {
            int cnt = 0;
            for (char c : s) {
                if (c == ab[cnt]) cnt++;
                else if (c == ab[0]) cnt = 1;
                else cnt = 0;
                if (cnt == 2) {
                    res += x;
                    cnt = 0;
                }
            }
            swap(ab, ba);
        }
        return res;
    }
};