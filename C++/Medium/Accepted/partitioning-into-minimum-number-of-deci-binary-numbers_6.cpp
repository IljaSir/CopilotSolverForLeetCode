class Solution {
public:
    int minPartitions(string n) {
        
        int max = 0;
        for (int i = 0; i < n.length(); i++) {
            int c = n[i] - '0';
            if (c > max) {
                max = c;
            }
        }
        return max;
    }
};