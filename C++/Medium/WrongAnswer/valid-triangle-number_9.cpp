class Solution {
public:
    int triangleNumber(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        sort(nums.begin(), nums.end());
        for(int i = 0; i < n; ++i) {
            int k = i + 2;
            for(int j = i + 1; j < n; ++j) {
                while(k < n && nums[i] + nums[j] > nums[k]) {
                    ++k;
                }
                res += k - j - 1;
            }
        }
        return res;
    }
};