class Solution {
public:
    string smallestNumber(string pattern) {
        
        string result;
        int n = pattern.length();
        int min = 1;
        int max = n + 1;
        for (int i = 0; i < n; i++) {
            if (pattern[i] == 'I') {
                result.push_back(min + '0');
                min++;
            } else {
                result.push_back(max + '0');
                max--;
            }
        }
        result.push_back(min + '0');
        return result;
    }
};