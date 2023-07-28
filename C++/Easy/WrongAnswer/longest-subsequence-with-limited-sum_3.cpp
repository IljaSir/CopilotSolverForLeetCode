class Solution {
public:
    vector<int> answerQueries(vector<int>& nums, vector<int>& queries) {
        
        vector<int> answer(queries.size(), 0);
        vector<int> prefixSum(nums.size()+1, 0);
        for (int i = 0; i < nums.size(); ++i) {
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }
        for (int i = 0; i < queries.size(); ++i) {
            int left = 0, right = nums.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (prefixSum[mid+1] <= queries[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            answer[i] = left;
        }
        return answer;
    }
};