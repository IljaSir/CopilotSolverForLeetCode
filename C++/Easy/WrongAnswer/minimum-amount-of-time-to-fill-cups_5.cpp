class Solution {
public:
    int fillCups(vector<int>& amount) {
        
        int n = amount.size();
        if (n == 0) return 0;
        int res = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += amount[i];
        }
        int diff = 0;
        int minDiff = 0;
        for (int i = 0; i < n; i++) {
            diff += amount[i] - amount[(i + 1) % n];
            minDiff = min(minDiff, diff);
        }
        return sum - minDiff;
    }
};