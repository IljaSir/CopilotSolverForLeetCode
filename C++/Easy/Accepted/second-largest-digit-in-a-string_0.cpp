class Solution {
public:
    int secondHighest(string s) {
        
        int max = -1;
        int secondMax = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s[i] >= '0' && s[i] <= '9') {
                int number = s[i] - '0';
                if (number > max) {
                    secondMax = max;
                    max = number;
                } else if (number > secondMax && number < max) {
                    secondMax = number;
                }
            }
        }
        return secondMax;
    }
};