class Solution {
public:
    vector<int> answerQueries(vector<int>& nums, vector<int>& queries) {
        
        vector<int> ans;
        int n = nums.size();
        int m = queries.size();
        for (int i = 0; i < m; i++) {
            int sum = 0;
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (sum + nums[j] <= queries[i]) {
                    sum += nums[j];
                    count++;
                }
            }
            ans.push_back(count);
        }
        return ans;
    }
};