class Solution {
public:
    int findLongestChain(vector<vector<int>>& pairs) {
        
        sort(pairs.begin(), pairs.end(), [](vector<int>&a, vector<int>&b) {
            return a[1] < b[1];
        });
        int n = pairs.size();
        int res = 1;
        int cur = pairs[0][1];
        for (int i = 1; i < n; i++) {
            if (cur < pairs[i][0]) {
                res++;
                cur = pairs[i][1];
            }
        }
        return res;
    }
};