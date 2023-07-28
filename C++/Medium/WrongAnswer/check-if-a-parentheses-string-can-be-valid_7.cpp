class Solution {
public:
    bool canBeValid(string s, string locked) {
        
        int n = s.size();
        vector<int> open(n, 0);
        vector<int> close(n, 0);
        int openCount = 0;
        int closeCount = 0;
        for (int i = 0; i < n; i++) {
            if (locked[i] == '1') {
                if (s[i] == '(') {
                    openCount++;
                } else {
                    closeCount++;
                }
            } else {
                if (s[i] == '(') {
                    open[i] = 1;
                    openCount++;
                } else {
                    close[i] = 1;
                    closeCount++;
                }
            }
        }
        if (openCount != closeCount) {
            return false;
        }
        vector<int> openPrefixSum(n, 0);
        vector<int> closePrefixSum(n, 0);
        for (int i = 0; i < n; i++) {
            openPrefixSum[i] = open[i];
            closePrefixSum[i] = close[i];
            if (i > 0) {
                openPrefixSum[i] += openPrefixSum[i - 1];
                closePrefixSum[i] += closePrefixSum[i - 1];
            }
        }
        for (int i = 0; i < n; i++) {
            if (locked[i] == '1') {
                continue;
            }
            if (s[i] == '(') {
                if (closePrefixSum[i] > 0) {
                    return true;
                }
            } else {
                if (openPrefixSum[i] > 0) {
                    return true;
                }
            }
        }
        return false;
    }
};