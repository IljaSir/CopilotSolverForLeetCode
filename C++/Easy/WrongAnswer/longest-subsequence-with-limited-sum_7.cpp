class Solution {
public:
    vector<int> answerQueries(vector<int>& nums, vector<int>& queries) {
        
        int n = nums.size();
        int m = queries.size();
        vector<int> answer(m);
        vector<int> dp(1000001, 0);
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1000000; j >= nums[i]; j--) {
                if (dp[j - nums[i]] == 1) {
                    dp[j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = queries[i]; j >= 0; j--) {
                if (dp[j] == 1) {
                    answer[i] = j;
                    break;
                }
            }
        }
        return answer;
    }
};