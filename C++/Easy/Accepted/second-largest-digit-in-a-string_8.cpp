class Solution {
public:
    int secondHighest(string s) {
        
        int max = -1, second_max = -1;
        for (auto c: s) {
            if (c >= '0' && c <= '9') {
                int num = c - '0';
                if (num > max) {
                    second_max = max;
                    max = num;
                } else if (num > second_max && num != max) {
                    second_max = num;
                }
            }
        }
        return second_max;
    }
};