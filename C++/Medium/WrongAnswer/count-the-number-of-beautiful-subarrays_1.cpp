class Solution {
public:
    long long beautifulSubarrays(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> odd;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                odd.push_back(i);
            }
        }
        long long ans = 0;
        for (int i = 0; i < odd.size(); i++) {
            int l = odd[i] - (i == 0 ? -1 : odd[i - 1]);
            int r = (i == odd.size() - 1 ? n : odd[i + 1]) - odd[i];
            ans += l * r;
        }
        return ans;
    }
};