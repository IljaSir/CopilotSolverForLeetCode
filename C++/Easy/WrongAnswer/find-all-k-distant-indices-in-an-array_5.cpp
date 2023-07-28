class Solution {
public:
    vector<int> findKDistantIndices(vector<int>& nums, int key, int k) {
        
        vector<int> ans;
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] == key) {
                ans.push_back(i);
                for (int j = i - 1; j >= 0; --j) {
                    if (nums[j] == key) break;
                    if (i - j <= k) ans.push_back(j);
                    else break;
                }
                for (int j = i + 1; j < nums.size(); ++j) {
                    if (nums[j] == key) break;
                    if (j - i <= k) ans.push_back(j);
                    else break;
                }
            }
        }
        return ans;
    }
};