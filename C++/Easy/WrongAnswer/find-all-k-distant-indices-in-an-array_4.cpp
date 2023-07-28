class Solution {
public:
    vector<int> findKDistantIndices(vector<int>& nums, int key, int k) {
        
        vector<int> ans;
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] == key) {
                ans.push_back(i);
            }
        }
        vector<int> result;
        int j = 0;
        for (int i = 0; i < nums.size(); ++i) {
            while (j < ans.size() && ans[j] <= i + k) ++j;
            if (j < ans.size() && ans[j] == i + k + 1) {
                result.push_back(i);
            }
        }
        return result;
    }
};