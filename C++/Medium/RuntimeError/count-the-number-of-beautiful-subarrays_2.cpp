class Solution {
public:
    long long beautifulSubarrays(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> odd;
        odd.push_back(-1);
        for(int i = 0; i < n; i++) {
            if(nums[i] & 1) odd.push_back(i);
        }
        odd.push_back(n);
        long long res = 0;
        for(int i = 1; i < odd.size(); i++) {
            res += 1LL * (odd[i] - odd[i - 1]) * (odd[i + 1] - odd[i]);
        }
        return res;
    }
};