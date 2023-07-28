class Solution {
public:
    int minSwaps(string s) {
        
        int n = s.size();
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (s[i] == '[') {
                cnt++;
            } else {
                cnt--;
            }
        }
        if (cnt != 0) {
            return -1;
        }
        int res = 0, cur = 0;
        for (int i = 0; i < n; ++i) {
            if (s[i] == '[') {
                cur++;
            } else {
                cur--;
            }
            if (cur < 0) {
                res++;
                cur = 1;
            }
        }
        return res;
    }
};