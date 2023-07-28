class Solution {
public:
    string originalDigits(string s) {
        
        int count[26] = {0};
        for (auto ch : s) {
            count[ch - 'a']++;
        }
        int digits[10] = {0};
        digits[0] = count['z' - 'a'];
        digits[2] = count['w' - 'a'];
        digits[4] = count['u' - 'a'];
        digits[6] = count['x' - 'a'];
        digits[8] = count['g' - 'a'];
        digits[3] = count['h' - 'a'] - digits[8];
        digits[5] = count['f' - 'a'] - digits[4];
        digits[7] = count['s' - 'a'] - digits[6];
        digits[1] = count['o' - 'a'] - digits[0] - digits[2] - digits[4];
        digits[9] = count['i' - 'a'] - digits[5] - digits[6] - digits[8];
        string result;
        for (int i = 0; i < 10; ++i) {
            result += string(digits[i], i + '0');
        }
        return result;
    }
};