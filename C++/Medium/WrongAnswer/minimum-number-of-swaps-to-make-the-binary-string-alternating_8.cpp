class Solution {
public:
    int minSwaps(string s) {
        
        int n = s.size();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] != '0' + (i % 2)) {
                cnt++;
            }
        }
        if (cnt % 2 == 1) {
            return -1;
        }
        return min(cnt / 2, (n - cnt) / 2);
    }
};