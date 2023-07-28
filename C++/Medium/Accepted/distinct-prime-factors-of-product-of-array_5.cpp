class Solution {
public:
    int distinctPrimeFactors(vector<int>& nums) {
        
        int n = nums.size();
        int max_num = 0;
        for (int i = 0; i < n; i++) {
            max_num = max(max_num, nums[i]);
        }
        vector<int> prime(max_num + 1, 0);
        for (int i = 2; i <= max_num; i++) {
            if (prime[i] == 0) {
                for (int j = i; j <= max_num; j += i) {
                    prime[j] = i;
                }
            }
        }
        unordered_set<int> set;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            while (num > 1) {
                set.insert(prime[num]);
                num /= prime[num];
            }
        }
        return set.size();
    }
};