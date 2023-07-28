class Solution {
public:
    vector<int> findKDistantIndices(vector<int>& nums, int key, int k) {
        
        vector<int> ans;
        for(int i = 0; i < nums.size(); i++) {
            if(nums[i] == key) {
                ans.push_back(i);
            }
        }
        int i = 0;
        for(; i < ans.size(); i++) {
            if(ans[i] - k > 0) {
                break;
            }
        }
        ans.erase(ans.begin(), ans.begin() + i);
        i = ans.size() - 1;
        for(; i >= 0; i--) {
            if(ans[i] + k < nums.size()) {
                break;
            }
        }
        ans.erase(ans.begin() + i + 1, ans.end());
        return ans;
    }
};