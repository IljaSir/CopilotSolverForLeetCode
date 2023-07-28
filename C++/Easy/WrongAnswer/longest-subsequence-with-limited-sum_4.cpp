class Solution {
public:
    vector<int> answerQueries(vector<int>& nums, vector<int>& queries) {
        
        int n = nums.size();
        int m = queries.size();
        vector<int> answer(m);
        vector<int> prefixSum(n+1);
        for (int i = 1; i <= n; ++i) {
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
        }
        for (int i = 0; i < m; ++i) {
            int sum = queries[i];
            int low = 0;
            int high = n;
            while (low < high) {
                int mid = low + (high-low)/2;
                if (prefixSum[mid] <= sum) {
                    low = mid+1;
                } else {
                    high = mid;
                }
            }
            answer[i] = low-1;
        }
        return answer;
    }
};