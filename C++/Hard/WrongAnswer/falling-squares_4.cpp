class Solution {
public:
    vector<int> fallingSquares(vector<vector<int>>& positions) {
        
        vector<int> ans;
        int n = positions.size();
        vector<int> ends(n, 0);
        vector<int> heights(n, 0);
        for (int i = 0; i < n; ++i) {
            int l = positions[i][0];
            int r = l + positions[i][1];
            int h = positions[i][1];
            ends[i] = r;
            heights[i] = h;
            for (int j = 0; j < i; ++j) {
                if (ends[j] > l && ends[j] > r) {
                    heights[i] = max(heights[i], h + heights[j]);
                }
            }
            ans.push_back(*max_element(heights.begin(), heights.end()));
        }
        return ans;
    }
};