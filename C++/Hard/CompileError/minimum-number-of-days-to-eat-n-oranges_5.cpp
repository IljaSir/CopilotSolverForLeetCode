class Solution {
public:
    int minDays(int n) {
        
        unordered_map<int, int> dp;
        return minDays(n, dp);
    }
};