class Solution {
public:
    string smallestNumber(string pattern) {
        
        int n = pattern.size();
        string num = "";
        int i = 1;
        int j = n + 1;
        for (int k = 0; k < n; ++k) {
            if (pattern[k] == 'I') {
                num += to_string(i);
                ++i;
            } else {
                num += to_string(j);
                --j;
            }
        }
        num += to_string(i);
        return num;
    }
};