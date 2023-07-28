class Solution {
public:
    vector<long long> kthPalindrome(vector<int>& queries, int intLength) {
        
        int len = queries.size();
        vector<long long> res(len, -1);
        vector<long long> palindromes;
        generatePalindromes(palindromes, intLength);
        for (int i = 0; i < len; ++i) {
            if (queries[i] <= palindromes.size()) {
                res[i] = palindromes[queries[i] - 1];
            }
        }
        return res;
    }
};