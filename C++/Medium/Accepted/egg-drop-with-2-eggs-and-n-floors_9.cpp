class Solution {
public:
    int twoEggDrop(int n) {
        
        int drops = 0;
        while (n > 0) {
            n -= ++drops;
        }
        return drops;
    }
};