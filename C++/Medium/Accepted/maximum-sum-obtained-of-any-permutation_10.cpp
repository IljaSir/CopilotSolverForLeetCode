class Solution {
public:
    int maxSumRangeQuery(vector<int>& nums, vector<vector<int>>& requests) {
        
        vector<int> n(nums.size(), 0);
        for (auto req : requests) {
            n[req[0]]++;
            if (req[1] < n.size() - 1) {
                n[req[1] + 1]--;
            }
        }
        for (int i = 1; i < n.size(); i++) {
            n[i] += n[i - 1];
        }
        sort(n.begin(), n.end());
        sort(nums.begin(), nums.end());
        long long result = 0;
        for (int i = 0; i < nums.size(); i++) {
            result += (long long)n[i] * nums[i];
        }
        return result % 1000000007;
    }
};