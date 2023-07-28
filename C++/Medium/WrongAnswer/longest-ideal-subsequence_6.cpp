class Solution {
public:
    int longestIdealString(string s, int k) {
        
        int n = s.size();
        vector<int> maxc(n + 1, -1), minc(n + 1, 26);
        for (int i = 0; i < n; ++i) {
            int c = s[i] - 'a';
            maxc[i + 1] = max(maxc[i], c);
            minc[i + 1] = min(minc[i], c);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int l = i, r = n;
            while (l < r) {
                int mid = (l + r + 1) / 2;
                if (maxc[mid] - minc[mid] <= k) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            ans = max(ans, l - i);
        }
        return ans;
    }
};