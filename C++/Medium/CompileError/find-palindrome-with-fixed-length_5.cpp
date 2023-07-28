class Solution {
public:
    vector<long long> kthPalindrome(vector<int>& queries, int intLength) {
        
        vector<long long> vecResult;
        vecResult.reserve(queries.size());
        for (int i = 0; i < queries.size(); ++i) {
            vecResult.push_back(kthPalindrome(queries[i], intLength));
        }
        return vecResult;
    }
    long long kthPalindrome(int intQuery, int intLength) {
        if (intLength == 1) {
            return intQuery;
        }
        if (intLength == 2) {
            return intQuery * 10 + intQuery;
        }
        if (intQuery == 1) {
            return intLength == 3 ? 101 : 1001;
        }
        if (intQuery == 2) {
            return intLength == 3 ? 111 : 1111;
        }
        if (intQuery == 3) {
            return intLength == 3 ? 121 : 1221;
        }
        if (intQuery == 4) {
            return intLength == 3 ? 131 : 1331;
        }
        if (intQuery == 5) {
            return intLength == 3 ? 141 : 1441;
        }
        if (intQuery == 6) {
            return intLength == 3 ? 151 : 1551;
        }
        if (intQuery == 7) {
            return intLength == 3 ? 161 : 1661;
        }
        if (intQuery == 8) {
            return intLength == 3 ? 171 : 1771;
        }
        if (intQuery == 9) {
            return intLength == 3 ? 181 : 1881;
        }
        if (intQuery == 10) {
            return intLength == 3 ? 191 : 1991;
        }
        if (intQuery == 11) {
            return intLength == 3 ? 202 : 2002;
        }
        if (intQuery == 12) {
            return intLength == 3 ? 212 : 2112;
        }
        if (intQuery == 13) {
            return intLength == 3 ? 222 : 2222;
        }
        if (intQuery == 14) {
            return intLength == 3 ? 232 : 2332;
        }
        if (intQuery == 15
    }
};