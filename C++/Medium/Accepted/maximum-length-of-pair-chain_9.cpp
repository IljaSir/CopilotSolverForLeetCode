class Solution {
public:
    int findLongestChain(vector<vector<int>>& pairs) {
        
        sort(pairs.begin(), pairs.end(), [](const auto& a, const auto& b) {
            return a[1] < b[1];
        });
        int ans = 0;
        int end = -1001;
        for (auto& p : pairs) {
            if (p[0] > end) {
                end = p[1];
                ans++;
            }
        }
        return ans;
    }
};