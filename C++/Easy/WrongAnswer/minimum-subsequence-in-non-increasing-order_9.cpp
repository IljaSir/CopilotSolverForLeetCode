class Solution {
public:
    vector<int> minSubsequence(vector<int>& nums) {
        
        vector<int> res;
        int sum = 0;
        for (auto n : nums) sum += n;
        sort(nums.begin(), nums.end());
        int half = sum / 2;
        while (sum > 0) {
            int n = nums.back();
            nums.pop_back();
            res.push_back(n);
            sum -= n;
            if (sum <= half) break;
        }
        return res;
    }
};