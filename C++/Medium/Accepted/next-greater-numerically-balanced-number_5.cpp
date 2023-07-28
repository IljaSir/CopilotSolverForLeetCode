class Solution {
public:
    int nextBeautifulNumber(int n) {
        
        int res = n + 1;
        while (true) {
            string s = to_string(res);
            int cnt[10] = {0};
            for (char c : s) {
                ++cnt[c - '0'];
            }
            bool ok = true;
            for (char c : s) {
                if (cnt[c - '0'] != c - '0') {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return res;
            }
            ++res;
        }
        return 0;
    }
};