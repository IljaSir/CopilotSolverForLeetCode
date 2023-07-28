class Solution {
public:
    vector<bool> prefixesDivBy5(vector<int>& nums) {
        
        int n = nums.size();
        vector<bool> res(n, false);
        int x = 0;
        for (int i = 0; i < n; i++) {
            x = (x * 2 + nums[i]) % 5;
            if (x == 0) {
                res[i] = true;
            }
        }
        return res;
    }
};