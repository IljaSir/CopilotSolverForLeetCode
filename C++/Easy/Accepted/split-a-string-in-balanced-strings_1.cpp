class Solution {
public:
    int balancedStringSplit(string s) {
        
        int count = 0, result = 0;
        for (char c : s) {
            if (c == 'L') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                result++;
            }
        }
        return result;
    }
};