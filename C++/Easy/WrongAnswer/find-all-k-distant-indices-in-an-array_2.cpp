class Solution {
public:
    vector<int> findKDistantIndices(vector<int>& nums, int key, int k) {
        
        vector<int> ans;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            if (nums[i] != key) continue;
            for (int j = max(0, i - k); j <= min(n - 1, i + k); j++) {
                if (nums[j] == key) {
                    ans.push_back(j);
                    break;
                }
            }
        }
        return ans;
    }
};