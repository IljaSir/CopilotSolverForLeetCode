class Solution {
public:
    long long beautifulSubarrays(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> odd;
        for(int i = 0; i < n; ++i) {
            if(nums[i] & 1) {
                odd.push_back(i);
            }
        }
        long long ans = 0;
        for(int i = 0; i < odd.size(); ++i) {
            int left = 0, right = 0;
            if(i == 0) {
                left = odd[i] + 1;
            } else {
                left = odd[i] - odd[i - 1];
            }
            if(i == odd.size() - 1) {
                right = n - odd[i];
            } else {
                right = odd[i + 1] - odd[i];
            }
            ans += left * right;
        }
        return ans;
    }
};