class Solution {
public:
    int heightChecker(vector<int>& heights) {
        
        int n = heights.size();
        vector<int> expected = heights;
        sort(expected.begin(), expected.end());
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (heights[i] != expected[i]) {
                ++res;
            }
        }
        return res;
    }
};