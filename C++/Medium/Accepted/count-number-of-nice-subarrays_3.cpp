class Solution {
public:
    int numberOfSubarrays(vector<int>& nums, int k) {
        
        int n = nums.size();
        int ans = 0;
        vector<int> odd;
        odd.push_back(-1);
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                odd.push_back(i);
            }
        }
        odd.push_back(n);
        for (int i = 1; i + k < odd.size(); i++) {
            ans += (odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]);
        }
        return ans;
    }
};