class Solution {
public:
    vector<long long> kthPalindrome(vector<int>& queries, int intLength) {
        
        vector<long long> result;
        for (auto query : queries) {
            result.push_back(kthPalindrome(query, intLength));
        }
        return result;
    }
    long long kthPalindrome(int query, int intLength) {
        if (query == 1) {
            return 10 * query + 1;
        }
        if (intLength == 1) {
            return query;
        }
        if (intLength == 2) {
            return query * 11;
        }
        if (intLength == 3) {
            return query * 111;
        }
        int half = (intLength + 1) / 2;
        int base = pow(10, half - 1);
        int max = base * 10 - 1;
        int min = base;
        int range = max - min + 1;
        int count = 0;
        for (int i = min; i <= max; i++) {
            long long palindrome = toPalindrome(i);
            if (palindrome > query) {
                count++;
            }
        }
        if (count < query) {
            return -1;
        }
        int start = min;
        int end = max;
        while (start < end) {
            int mid = (start + end) / 2;
            long long palindrome = toPalindrome(mid);
            if (palindrome > query) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return toPalindrome(start);
    }
};