class Solution {
public:
    vector<int> sortArrayByParityII(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> res(n);
        int i = 0, j = 1;
        for (int k = 0; k < n; k++) {
            if (nums[k] % 2 == 0) {
                res[i] = nums[k];
                i += 2;
            } else {
                res[j] = nums[k];
                j += 2;
            }
        }
        return res;
    }
};