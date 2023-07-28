class Solution {
public:
    int secondHighest(string s) {
        
        int max = -1;
        int second = -1;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] >= '0' && s[i] <= '9') {
                int num = s[i] - '0';
                if (num > max) {
                    second = max;
                    max = num;
                }
                else if (num > second && num != max) {
                    second = num;
                }
            }
        }
        return second;
    }
};