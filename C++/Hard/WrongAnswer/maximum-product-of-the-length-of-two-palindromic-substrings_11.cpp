class Solution {
public:
    long long maxProduct(string s) {
        
        int n = s.size();
        vector<int> left(n, 0), right(n, 0);
        for (int i = 0, j = n - 1, len = 0; i < n; ++i, --j) {
            left[i] = (i > 0 ? left[i - 1] : 0) | (1 << (s[i] - 'a'));
            right[j] = (j < n - 1 ? right[j + 1] : 0) | (1 << (s[j] - 'a'));
        }
        long long ans = 0;
        for (int i = 0; i < n - 1; ++i) {
            int len1 = i + 1;
            if (len1 & 1 && (left[i] == right[0])) {
                for (int j = i + 1; j < n; ++j) {
                    int len2 = n - j;
                    if (len2 & 1 && (left[j - 1] == right[j])) {
                        ans = max(ans, (long long)len1 * len2);
                    }
                }
            }
        }
        return ans;
    }
};