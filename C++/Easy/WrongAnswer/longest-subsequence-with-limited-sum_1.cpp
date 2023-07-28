class Solution {
public:
    vector<int> answerQueries(vector<int>& nums, vector<int>& queries) {
        
        vector<int> answer;
        for (auto q : queries) {
            int count = 0;
            int sum = 0;
            for (auto n : nums) {
                if (sum + n <= q) {
                    sum += n;
                    count++;
                }
            }
            answer.push_back(count);
        }
        return answer;
    }
};