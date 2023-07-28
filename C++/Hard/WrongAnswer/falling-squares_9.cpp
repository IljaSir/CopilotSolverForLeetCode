class Solution {
public:
    vector<int> fallingSquares(vector<vector<int>>& positions) {
        
        vector<int> ans;
        int max_height = 0;
        set<int> pos;
        map<int, int> h;
        for (auto& position : positions) {
            int left = position[0], side = position[1];
            int right = left + side;
            auto l = pos.lower_bound(left);
            auto r = pos.upper_bound(right);
            int height = 0;
            for (auto it = l; it != r; ++it) {
                height = max(height, h[*it]);
            }
            height += side;
            max_height = max(max_height, height);
            ans.push_back(max_height);
            pos.insert(l, right);
            h[left] = h[right] = height;
        }
        return ans;
    }
};