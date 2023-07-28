class Solution {
public:
    int longestIdealString(string s, int k) {
        
        int n = s.size();
        vector<int> left(n), right(n);
        left[0] = 0;
        for (int i = 1; i < n; ++i) {
            if (s[i] - s[i - 1] <= k) {
                left[i] = left[i - 1];
            } else {
                left[i] = i;
            }
        }
        right[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; --i) {
            if (s[i + 1] - s[i] <= k) {
                right[i] = right[i + 1];
            } else {
                right[i] = i;
            }
        }
        int ans = 0;
        for (int i = 0; i < n - 1; ++i) {
            ans = max(ans, right[i + 1] - left[i] + 1);
        }
        return ans;
    }
};