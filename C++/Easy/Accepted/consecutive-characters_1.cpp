class Solution {
public:
    int maxPower(string s) {
        
        int max = 1;
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s[i] == s[i-1]) {
                count++;
                if (count > max) {
                    max = count;
                }
            } else {
                count = 1;
            }
        }
        return max;
    }
};