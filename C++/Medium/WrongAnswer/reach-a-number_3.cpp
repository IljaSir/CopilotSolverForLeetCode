class Solution {
public:
    int reachNumber(int target) {
        
        target = abs(target);
        int sum = 0, i = 1;
        while (sum < target) {
            sum += i;
            i++;
        }
        if (sum == target) return i - 1;
        int diff = sum - target;
        if (diff % 2 == 0) return i - 1;
        if (i % 2 == 0) return i;
        return i + 1;
    }
};