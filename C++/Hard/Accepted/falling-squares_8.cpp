class Solution {
public:
    vector<int> fallingSquares(vector<vector<int>>& positions) {
        
        vector<int> ans;
        int n = positions.size();
        int maxh = 0;
        vector<int> heights(n, 0);
        for(int i = 0; i < n; i++) {
            int l = positions[i][0], r = l + positions[i][1];
            int h = 0;
            for(int j = 0; j < i; j++) {
                int l1 = positions[j][0], r1 = l1 + positions[j][1];
                if(l < r1 && r > l1) {
                    h = max(h, heights[j]);
                }
            }
            h += positions[i][1];
            maxh = max(maxh, h);
            ans.push_back(maxh);
            heights[i] = h;
        }
        return ans;
    }
};