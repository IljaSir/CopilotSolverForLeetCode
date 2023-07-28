class Solution {
public:
    int secondHighest(string s) {
        
        int max = -1;
        int secondMax = -1;
        for (int i = 0; i < s.length(); ++i) {
            if (s[i] >= '0' && s[i] <= '9') {
                int num = s[i] - '0';
                if (num > max) {
                    secondMax = max;
                    max = num;
                } else if (num > secondMax && num != max) {
                    secondMax = num;
                }
            }
        }
        return secondMax;
    }
};