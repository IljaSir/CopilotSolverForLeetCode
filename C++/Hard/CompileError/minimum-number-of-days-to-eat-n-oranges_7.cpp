class Solution {
public:
    int minDays(int n) {
        
        unordered_map<int, int> cache;
        return helper(n, cache);
    }
};