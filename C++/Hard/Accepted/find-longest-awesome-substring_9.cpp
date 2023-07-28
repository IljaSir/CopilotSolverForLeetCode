class Solution {
public:
    int longestAwesome(string s) {
        
        int n = s.size();
        int m = 0;
        int l = 0;
        int r = 0;
        int t = 0;
        vector<int> v(1024, -2);
        v[0] = -1;
        for (int i = 0; i < n; i++) {
            t ^= (1 << (s[i] - '0'));
            if (v[t] == -2) {
                v[t] = i;
            }
            if (i - v[t] > m) {
                m = i - v[t];
                l = v[t];
                r = i;
            }
            for (int j = 0; j < 10; j++) {
                int t2 = t ^ (1 << j);
                if (v[t2] != -2) {
                    if (i - v[t2] > m) {
                        m = i - v[t2];
                        l = v[t2];
                        r = i;
                    }
                }
            }
        }
        return m;
    }
};