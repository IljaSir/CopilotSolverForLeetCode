class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        
        vector<int> result;
        int n = nums.size();
        int sum = (1 + n) * n / 2;
        int sum2 = 0;
        for (int i = 0; i < n; ++i) {
            sum2 += nums[i];
        }
        int sum3 = 0;
        unordered_set<int> set;
        for (int i = 0; i < n; ++i) {
            if (set.find(nums[i]) != set.end()) {
                sum3 = nums[i];
            }
            set.insert(nums[i]);
        }
        result.push_back(sum3);
        result.push_back(sum + sum3 - sum2);
        return result;
    }
};