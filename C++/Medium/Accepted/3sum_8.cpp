class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        
        vector<vector<int>> ret;
        int n = nums.size();
        if(n < 3) return ret;
        sort(nums.begin(), nums.end());
        for(int i = 0; i < n - 2; ++i) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = n - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    ret.push_back({nums[i], nums[j], nums[k]});
                    ++j;
                    while(j < k && nums[j] == nums[j - 1]) ++j;
                }
                else if(sum > 0) --k;
                else ++j;
            }
        }
        return ret;
    }
};