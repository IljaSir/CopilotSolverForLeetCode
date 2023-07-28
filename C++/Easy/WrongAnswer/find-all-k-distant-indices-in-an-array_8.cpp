class Solution {
public:
    vector<int> findKDistantIndices(vector<int>& nums, int key, int k) {
        
        vector<int> res;
        int n = nums.size();
        int i = 0;
        for (int j = 0; j < n; ++j) {
            if (nums[j] == key) {
                while (i < j && j - i > k) ++i;
                if (j - i <= k) res.push_back(i);
                ++i;
            }
        }
        return res;
    }
};