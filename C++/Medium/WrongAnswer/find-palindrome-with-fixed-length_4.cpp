class Solution {
public:
    vector<long long> kthPalindrome(vector<int>& queries, int intLength) {
        
        vector<long long> res;
        for (auto q : queries) {
            res.push_back(findKthPalindrome(q, intLength));
        }
        return res;
    }
    long long findKthPalindrome(long long k, int intLength) {
        long long min = 1;
        for (int i = 1; i < intLength; ++i) {
            min *= 10;
        }
        long long max = min * 10 - 1;
        long long cur = min;
        long long count = 0;
        if (intLength == 1) {
            return k;
        }
        while (cur <= max) {
            if (isPalindrome(cur)) {
                count++;
            }
            if (count == k) {
                return cur;
            }
            cur++;
        }
        return -1;
    }
    bool isPalindrome(long long num) {
        long long rev = 0;
        long long n = num;
        while (n > 0) {
            long long digit = n % 10;
            rev = rev * 10 + digit;
            n /= 10;
        }
        return rev == num;
    }
};