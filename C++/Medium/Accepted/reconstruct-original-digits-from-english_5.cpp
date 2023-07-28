class Solution {
public:
    string originalDigits(string s) {
        
        vector<int> cnt(26, 0);
        for (char c: s) cnt[c - 'a']++;
        vector<int> num(10, 0);
        num[0] = cnt['z' - 'a'];
        num[2] = cnt['w' - 'a'];
        num[4] = cnt['u' - 'a'];
        num[6] = cnt['x' - 'a'];
        num[8] = cnt['g' - 'a'];
        num[3] = cnt['h' - 'a'] - num[8];
        num[5] = cnt['f' - 'a'] - num[4];
        num[7] = cnt['s' - 'a'] - num[6];
        num[9] = cnt['i' - 'a'] - num[5] - num[6] - num[8];
        num[1] = cnt['n' - 'a'] - num[7] - 2 * num[9];
        string res;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < num[i]; j++) res += to_string(i);
        }
        return res;
    }
};