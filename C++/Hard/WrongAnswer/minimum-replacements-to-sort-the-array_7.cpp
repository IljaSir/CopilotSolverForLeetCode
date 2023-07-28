class Solution {
public:
    long long minimumReplacement(vector<int>& nums) {
        
        long long ans = 0;
        int n = nums.size();
        for(int i = 0; i < n; ++i) {
            if(nums[i] & 1) {
                if(i == n - 1) {
                    ans += 1;
                } else {
                    nums[i + 1] += 1;
                    ans += 2;
                }
            }
        }
        return ans;
    }
};