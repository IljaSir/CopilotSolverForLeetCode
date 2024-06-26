class Solution {
public:
    int minPartitions(string n) {
        
        int max = 0;
        for (auto c : n) {
            if (c - '0' > max) max = c - '0';
        }
        return max;
    }
};