class Solution {
public:
    vector<long long> kthPalindrome(vector<int>& queries, int intLength) {
        
        vector<long long> answer;
        for (int i = 0; i < queries.size(); i++) {
            long long num = queries[i];
            long long palindrome = 0;
            long long base = 1;
            for (int j = 0; j < intLength / 2; j++) {
                palindrome += base * (num % 10);
                num /= 10;
                base *= 10;
            }
            if (intLength % 2 == 1) {
                palindrome += base * (num % 10);
                num /= 10;
                base *= 10;
            }
            for (int j = 0; j < intLength / 2; j++) {
                palindrome += base * (num % 10);
                num /= 10;
                base *= 10;
            }
            answer.push_back(palindrome);
        }
        return answer;
    }
};