class Solution {
public:
    int findLongestChain(vector<vector<int>>& pairs) {
        
        sort(pairs.begin(), pairs.end(), [](auto &a, auto &b) {
            return a[1] < b[1];
        });
        int ans = 0;
        int cur = INT_MIN;
        for (auto &p : pairs) {
            if (p[0] > cur) {
                cur = p[1];
                ans++;
            }
        }
        return ans;
    }
};