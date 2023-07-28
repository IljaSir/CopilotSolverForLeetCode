class Solution {
public:
    long long kMirror(int k, int n) {
        
        vector<long long> nums;
        for (int i = 1; i < k; i++) {
            nums.push_back(i);
        }
        for (int i = 0; i < n; i++) {
            long long num = nums[i];
            long long next = num * k;
            nums.push_back(next);
            long long rev = 0;
            for (long long x = num; x > 0; x /= k) {
                rev = rev * k + x % k;
            }
            nums.push_back(next + rev);
        }
        return accumulate(nums.begin(), nums.begin() + n, 0LL);
    }
};