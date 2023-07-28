class Solution {
public:
    int distinctPrimeFactors(vector<int>& nums) {
        
        int n = nums.size();
        int maxNum = 0;
        for (int i = 0; i < n; i++) {
            maxNum = max(maxNum, nums[i]);
        }
        vector<int> primeFactors(maxNum + 1, 0);
        for (int i = 2; i <= maxNum; i++) {
            if (primeFactors[i] == 0) {
                for (int j = i; j <= maxNum; j += i) {
                    primeFactors[j]++;
                }
            }
        }
        unordered_set<int> distinctFactors;
        for (int i = 0; i < n; i++) {
            distinctFactors.insert(primeFactors[nums[i]]);
        }
        return distinctFactors.size();
    }
};