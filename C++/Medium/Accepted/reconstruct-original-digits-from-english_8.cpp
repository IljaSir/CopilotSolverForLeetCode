class Solution {
public:
    string originalDigits(string s) {
        
        int letterCnt[26] = {0};
        for (char c : s) letterCnt[c - 'a']++;
        int digitCnt[10] = {0};
        digitCnt[0] = letterCnt['z' - 'a'];
        digitCnt[2] = letterCnt['w' - 'a'];
        digitCnt[4] = letterCnt['u' - 'a'];
        digitCnt[6] = letterCnt['x' - 'a'];
        digitCnt[8] = letterCnt['g' - 'a'];
        digitCnt[3] = letterCnt['h' - 'a'] - digitCnt[8];
        digitCnt[5] = letterCnt['f' - 'a'] - digitCnt[4];
        digitCnt[7] = letterCnt['s' - 'a'] - digitCnt[6];
        digitCnt[9] = letterCnt['i' - 'a'] - digitCnt[5] - digitCnt[6] - digitCnt[8];
        digitCnt[1] = letterCnt['o' - 'a'] - digitCnt[0] - digitCnt[2] - digitCnt[4];
        
        string res;
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < digitCnt[i]; ++j) {
                res.push_back(i + '0');
            }
        }
        return res;
    }
};