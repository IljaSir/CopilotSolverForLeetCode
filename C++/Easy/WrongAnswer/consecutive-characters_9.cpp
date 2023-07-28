class Solution {
public:
    int maxPower(string s) {
        
        int count = 0, max = 0;
        char c = 0;
        for (auto i : s) {
            if (i == c) {
                count++;
                if (count > max) max = count;
            } else {
                c = i;
                count = 1;
            }
        }
        return max;
    }
};