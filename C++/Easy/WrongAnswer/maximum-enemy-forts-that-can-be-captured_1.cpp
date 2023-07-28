class Solution {
public:
    int captureForts(vector<int>& forts) {
        
        int n = forts.size();
        vector<int> left(n, 0);
        vector<int> right(n, 0);
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (forts[i] == 1) {
                cnt++;
            }
            left[i] = cnt;
        }
        cnt = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (forts[i] == 1) {
                cnt++;
            }
            right[i] = cnt;
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (forts[i] == 0) {
                int cnt = 0;
                if (i > 0) {
                    cnt += left[i - 1];
                }
                if (i < n - 1) {
                    cnt += right[i + 1];
                }
                ans = max(ans, cnt);
            }
        }
        return ans;
    }
};