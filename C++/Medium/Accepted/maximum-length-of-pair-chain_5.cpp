class Solution {
public:
    int findLongestChain(vector<vector<int>>& pairs) {
        
        sort(pairs.begin(), pairs.end(), [](vector<int>& a, vector<int>& b) {
            return a[1] < b[1];
        });
        int res = 0;
        int pre = INT_MIN;
        for (vector<int>& p : pairs) {
            if (pre < p[0]) {
                ++res;
                pre = p[1];
            }
        }
        return res;
    }
};