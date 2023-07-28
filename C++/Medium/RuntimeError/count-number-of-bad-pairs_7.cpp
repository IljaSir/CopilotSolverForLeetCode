class Solution {
public:
    long long countBadPairs(vector<int>& nums) {
        
        long long res = 0;
        int n = nums.size();
        vector<int> arr(n, 0);
        for (int i = 0; i < n; ++i) {
            int diff = nums[i] - i;
            res += arr[diff];
            ++arr[diff];
        }
        return res;
    }
};