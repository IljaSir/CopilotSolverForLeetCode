class Solution {
public:
    vector<long long> kthPalindrome(vector<int>& queries, int intLength) {
        
        vector<long long> answer(queries.size());
        for (int i = 0; i < queries.size(); ++i) {
            answer[i] = kthPalindrome(queries[i], intLength);
        }
        return answer;
    }
};