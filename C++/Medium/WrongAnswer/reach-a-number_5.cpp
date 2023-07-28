class Solution {
public:
    int reachNumber(int target) {
        
        int t = abs(target);
        int n = 0;
        while (t > 0) {
            t -= ++n;
        }
        if (t % 2 == 0) {
            return n;
        }
        return n + (n % 2 == 0 ? 2 : 1);
    }
};