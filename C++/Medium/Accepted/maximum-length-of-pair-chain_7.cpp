class Solution {
public:
    int findLongestChain(vector<vector<int>>& pairs) {
        
        sort(pairs.begin(), pairs.end(), [](const vector<int> &a, const vector<int> &b){return a[1] < b[1];});
        int ans = 0;
        int prev = INT_MIN;
        for (auto &p : pairs) {
            if (p[0] > prev) {
                prev = p[1];
                ++ans;
            }
        }
        return ans;
    }
};