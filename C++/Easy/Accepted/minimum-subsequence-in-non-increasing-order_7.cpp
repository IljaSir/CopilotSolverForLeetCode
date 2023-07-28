class Solution {
public:
    vector<int> minSubsequence(vector<int>& nums) {
        
        sort(nums.begin(), nums.end(), greater<int>());
        int sum = 0;
        for (auto n : nums) {
            sum += n;
        }
        int sum1 = 0;
        vector<int> res;
        for (auto n : nums) {
            res.push_back(n);
            sum1 += n;
            sum -= n;
            if (sum1 > sum) {
                return res;
            }
        }
        return res;
    }
};