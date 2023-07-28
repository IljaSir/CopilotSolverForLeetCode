class Solution {
public:
    vector<int> minDifference(vector<int>& nums, vector<vector<int>>& queries) {
        
        vector<int> ans;
        for (auto q: queries) {
            vector<int> a(101, 0);
            for (int i = q[0]; i <= q[1]; i++) {
                a[nums[i]]++;
            }
            int pre = -1;
            int minv = INT_MAX;
            for (int i = 0; i < 101; i++) {
                if (a[i] > 0) {
                    if (pre != -1) {
                        minv = min(minv, i - pre);
                    }
                    pre = i;
                }
            }
            if (minv == INT_MAX) {
                ans.push_back(-1);
            } else {
                ans.push_back(minv);
            }
        }
        return ans;
    }
};