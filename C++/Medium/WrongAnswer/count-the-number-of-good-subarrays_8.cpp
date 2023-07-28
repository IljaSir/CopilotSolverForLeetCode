class Solution {
public:
    long long countGood(vector<int>& nums, int k) {
        
        int n = nums.size();
        int cnt = 0;
        vector<int> cnts(n + 1, 0);
        cnts[0] = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum - k >= 0) {
                cnt += cnts[sum - k];
            }
            cnts[sum]++;
        }
        return cnt;
    }
};