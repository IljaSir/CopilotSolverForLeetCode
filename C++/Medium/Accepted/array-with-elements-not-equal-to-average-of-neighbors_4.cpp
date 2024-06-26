class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        vector<int> res(n);
        for (int i = 0, j = 0; i < n; i += 2, j++) {
            res[i] = nums[j];
        }
        for (int i = 1, j = n - 1; i < n; i += 2, j--) {
            res[i] = nums[j];
        }
        return res;
    }
};