class Solution {
public:
    vector<long long> kthPalindrome(vector<int>& queries, int intLength) {
        
        int len = queries.size();
        vector<long long> ans(len);
        for (int i = 0; i < len; i++) {
            ans[i] = kthPalindrome(queries[i], intLength);
        }
        return ans;
    }
    long long kthPalindrome(int k, int intLength) {
        int max = 1;
        for (int i = 1; i < intLength; i++) {
            max *= 10;
        }
        if (k >= max) {
            return -1;
        }
        int n = intLength / 2;
        int m = intLength - n;
        long long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = ans * 10 + (k % 10);
            k /= 10;
        }
        long long ans2 = ans;
        if (intLength % 2 == 1) {
            ans2 = ans2 * 10 + (k % 10);
            k /= 10;
        }
        while (ans > 0) {
            ans2 = ans2 * 10 + (ans % 10);
            ans /= 10;
        }
        return ans2;
    }
};