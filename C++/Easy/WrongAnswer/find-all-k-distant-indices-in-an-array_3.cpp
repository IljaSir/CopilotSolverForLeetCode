class Solution {
public:
    vector<int> findKDistantIndices(vector<int>& nums, int key, int k) {
        
        vector<int> ans;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == key) {
                ans.push_back(i);
            }
        }
        int l = 0, r = 0;
        vector<int> res;
        while (r < ans.size()) {
            if (ans[r] - ans[l] <= k) {
                res.push_back(ans[r]);
                r++;
            } else {
                l++;
            }
        }
        return res;
    }
};