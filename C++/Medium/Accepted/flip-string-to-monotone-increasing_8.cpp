class Solution {
public:
    int minFlipsMonoIncr(string s) {
        
        int n = s.size();
        if (n == 1) return 0;
        int zeroCount = 0;
        int oneCount = 0;
        for (char c : s) {
            if (c == '0') {
                zeroCount++;
            }
        }
        int minFlips = zeroCount;
        for (char c : s) {
            if (c == '0') {
                zeroCount--;
            } else {
                oneCount++;
            }
            minFlips = min(minFlips, zeroCount + oneCount);
        }
        return minFlips;
    }
};