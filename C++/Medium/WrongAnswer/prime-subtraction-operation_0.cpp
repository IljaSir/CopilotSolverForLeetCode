class Solution {
public:
    bool primeSubOperation(vector<int>& nums) {
        
        unordered_set<int> primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        for (int i = 1; i < nums.size(); ++i) {
            if (nums[i] <= nums[i - 1]) {
                int diff = nums[i - 1] - nums[i] + 1;
                bool found = false;
                for (int j = 2; j <= diff / j; ++j) {
                    if (diff % j == 0 && primes.count(j)) {
                        nums[i] += j;
                        found = true;
                        break;
                    }
                }
                if (!found && primes.count(diff)) {
                    nums[i] += diff;
                }
                if (nums[i] <= nums[i - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
};