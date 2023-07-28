class Solution {
public:
    vector<long long> kthPalindrome(vector<int>& queries, int intLength) {
        
        vector<long long> ans;
        for (auto q : queries) {
            long long x = 0;
            for (int i = 0; i < intLength / 2; ++i) {
                x = x * 10 + q % 10;
                q /= 10;
            }
            if (intLength % 2 == 1) x = x * 10 + q % 10;
            while (q > 0) {
                x = x * 10 + q % 10;
                q /= 10;
            }
            ans.push_back(x);
        }
        return ans;
    }
};