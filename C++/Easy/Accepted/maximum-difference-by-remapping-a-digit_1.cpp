class Solution {
public:
    int minMaxDifference(int num) {
        
        string s = to_string(num);
        int n = s.size();
        int mn = num, mx = num;
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                int c = 0;
                for (int k = 0; k < n; ++k) {
                    if (s[k] == '0' + i) {
                        s[k] = '0' + j;
                        ++c;
                    }
                }
                if (c > 0) {
                    int x = stoi(s);
                    mn = min(mn, x);
                    mx = max(mx, x);
                }
                s = to_string(num);
            }
        }
        return mx - mn;
    }
};