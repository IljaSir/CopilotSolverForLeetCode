class Solution {
public:
    string freqAlphabets(string s) {
        
        string result;
        for (int i = s.size() - 1; i >= 0; i--) {
            if (s[i] == '#') {
                result += 'a' + stoi(s.substr(i - 2, 2)) - 1;
                i -= 2;
            }
            else {
                result += 'a' + s[i] - '1';
            }
        }
        reverse(result.begin(), result.end());
        return result;
    }
};