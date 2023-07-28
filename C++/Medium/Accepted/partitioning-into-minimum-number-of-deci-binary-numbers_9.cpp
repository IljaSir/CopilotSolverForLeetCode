class Solution {
public:
    int minPartitions(string n) {
        
        int max = 0;
        for (auto c : n) {
            int i = c - '0';
            if (i > max) {
                max = i;
                if (max == 9) {
                    break;
                }
            }
        }
        return max;
    }
};