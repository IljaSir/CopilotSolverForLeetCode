class Solution {
public:
    vector<long long> kthPalindrome(vector<int>& queries, int intLength) {
        
        vector<long long> res;
        for(auto q : queries) {
            res.push_back(findKthPalindrome(q, intLength));
        }
        return res;
    }
};