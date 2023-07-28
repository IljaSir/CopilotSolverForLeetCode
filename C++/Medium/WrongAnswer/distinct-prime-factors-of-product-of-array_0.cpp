class Solution {
public:
    int distinctPrimeFactors(vector<int>& nums) {
        
        int max = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        vector<int> prime(max + 1, 0);
        for (int i = 2; i <= max; i++) {
            if (prime[i] == 0) {
                for (int j = i; j <= max; j += i) {
                    prime[j]++;
                }
            }
        }
        unordered_set<int> s;
        for (int i = 0; i < nums.size(); i++) {
            s.insert(prime[nums[i]]);
        }
        return s.size();
    }
};