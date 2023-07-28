class Solution {
public:
    int numberOfSubarrays(vector<int>& nums, int k) {
        
        int odd = 0;
        vector<int> odd_index;
        odd_index.push_back(-1);
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] % 2 == 1) {
                odd++;
                odd_index.push_back(i);
            }
        }
        odd_index.push_back(nums.size());
        if (odd < k) return 0;
        int ans = 0;
        for (int i = 1; i <= odd - k + 1; i++) {
            ans += (odd_index[i] - odd_index[i - 1]) * (odd_index[i + k] - odd_index[i + k - 1]);
        }
        return ans;
    }
};