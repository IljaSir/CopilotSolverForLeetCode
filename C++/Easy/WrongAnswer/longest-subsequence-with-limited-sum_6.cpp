class Solution {
public:
    vector<int> answerQueries(vector<int>& nums, vector<int>& queries) {
        
        int n = nums.size();
        int m = queries.size();
        vector<int> answer(m);
        vector<int> prefixSum(n+1);
        for (int i=0; i<n; i++) {
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }
        for (int i=0; i<m; i++) {
            int q = queries[i];
            int j = upper_bound(prefixSum.begin(), prefixSum.end(), q) - prefixSum.begin();
            answer[i] = j-1;
        }
        return answer;
    }
};