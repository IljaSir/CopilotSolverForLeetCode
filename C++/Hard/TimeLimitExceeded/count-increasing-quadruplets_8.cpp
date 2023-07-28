class Solution {
public:
    long long countQuadruplets(vector<int>& nums) {
        
        long long n = nums.size();
        long long ans = 0;
        for (long long i = 0; i < n; i++) {
            for (long long j = i + 1; j < n; j++) {
                for (long long k = j + 1; k < n; k++) {
                    for (long long l = k + 1; l < n; l++) {
                        if (nums[i] < nums[k] && nums[k] < nums[j] && nums[j] < nums[l]) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
};