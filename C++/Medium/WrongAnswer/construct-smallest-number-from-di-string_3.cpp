class Solution {
public:
    string smallestNumber(string pattern) {
        
        vector<int> digits;
        for (int i = 0; i < pattern.size() + 1; i++) {
            digits.push_back(i);
        }
        for (int i = 0; i < pattern.size(); i++) {
            if (pattern[i] == 'D') {
                int j = i;
                while (j < pattern.size() && pattern[j] == 'D') {
                    j++;
                }
                reverse(digits.begin() + i, digits.begin() + j + 1);
                i = j;
            }
        }
        string ret;
        for (int i = 0; i < digits.size(); i++) {
            ret.push_back('0' + digits[i]);
        }
        return ret;
    }
};