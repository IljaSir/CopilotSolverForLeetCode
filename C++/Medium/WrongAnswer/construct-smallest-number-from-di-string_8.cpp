class Solution {
public:
    string smallestNumber(string pattern) {
        
        string res;
        int n = pattern.length();
        int i = 0;
        int j = n;
        for (char c : pattern) {
            if (c == 'I') {
                res += to_string(i++);
            } else {
                res += to_string(j--);
            }
        }
        res += to_string(i);
        return res;
    }
};