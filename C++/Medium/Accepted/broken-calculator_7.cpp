class Solution {
public:
    int brokenCalc(int startValue, int target) {
        
        int res = 0;
        while (startValue < target) {
            res++;
            if (target % 2 == 1) target++;
            else target /= 2;
        }
        return res + startValue - target;
    }
};