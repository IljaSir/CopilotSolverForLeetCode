class Solution {
public:
    vector<int> answerQueries(vector<int>& nums, vector<int>& queries) {
        
        vector<int> answer(queries.size());
        sort(nums.begin(), nums.end());
        for (int i = 0; i < queries.size(); i++) {
            answer[i] = upper_bound(nums.begin(), nums.end(), queries[i]) - nums.begin();
        }
        return answer;
    }
};