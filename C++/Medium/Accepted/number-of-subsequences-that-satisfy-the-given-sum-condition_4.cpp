class Solution {
public:
    int numSubseq(vector<int>& nums, int target) {
        
        int N = nums.size();
        sort(nums.begin(), nums.end());
        vector<int> pow2(N, 1);
        for (int i = 1; i < N; ++i) {
            pow2[i] = pow2[i - 1] * 2 % 1000000007;
        }
        int res = 0;
        for (int i = 0, j = N - 1; i <= j; ++i) {
            while (i <= j && nums[i] + nums[j] > target) --j;
            if (i <= j) {
                res = (res + pow2[j - i]) % 1000000007;
            }
        }
        return res;
    }
};