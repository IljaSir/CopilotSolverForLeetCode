class Solution {
public:
    int numberOfSubarrays(vector<int>& nums, int k) {
        
        vector<int> odd;
        odd.push_back(-1);
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] & 1) odd.push_back(i);
        }
        odd.push_back(nums.size());
        int res = 0;
        for (int i = 1; i + k < odd.size(); i++) {
            res += (odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]);
        }
        return res;
    }
};