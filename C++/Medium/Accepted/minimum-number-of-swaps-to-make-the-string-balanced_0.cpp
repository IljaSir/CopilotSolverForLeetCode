class Solution {
public:
    int minSwaps(string s) {
        
        int n = s.size();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '[') {
                cnt++;
            } else {
                cnt--;
            }
        }
        if (cnt != 0) {
            return -1;
        }
        int res = 0;
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '[') {
                tmp++;
            } else {
                tmp--;
            }
            if (tmp < 0) {
                res++;
                tmp = 1;
            }
        }
        return res;
    }
};