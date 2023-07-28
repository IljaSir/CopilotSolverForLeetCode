class Solution {
public:
    vector<int> minSubsequence(vector<int>& nums) {
        
        vector<int> ans;
        int sum = 0;
        for (int n: nums)
            sum += n;
        sort(nums.begin(), nums.end(), greater<int>());
        int tmp = 0;
        for (int n: nums) {
            ans.push_back(n);
            tmp += n;
            if (tmp > sum - tmp)
                break;
        }
        return ans;
    }
};