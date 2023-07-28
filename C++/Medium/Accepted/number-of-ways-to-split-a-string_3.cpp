class Solution {
public:
    int numWays(string s) {
        
        int oneCount = 0;
        for (int i=0; i<s.length(); i++) {
            if (s[i] == '1') {
                oneCount++;
            }
        }
        if (oneCount % 3 != 0) {
            return 0;
        }
        if (oneCount == 0) {
            return (long long)(s.length() - 1) * (s.length() - 2) / 2 % 1000000007;
        }
        int target = oneCount / 3;
        int count = 0;
        int first = 0;
        int second = 0;
        for (int i=0; i<s.length(); i++) {
            if (s[i] == '1') {
                count++;
            }
            if (count == target) {
                first++;
            }
            if (count == target * 2) {
                second++;
            }
        }
        return (long long)first * second % 1000000007;
    }
};