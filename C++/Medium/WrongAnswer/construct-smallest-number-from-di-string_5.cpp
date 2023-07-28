class Solution {
public:
    string smallestNumber(string pattern) {
        
        int n = pattern.size();
        string res = "";
        int i = 0, j = n;
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