class Solution {
public:
    int minOperations(int n) {
        
        int res = 0;
        for (int i = 0; i < n; i += 2) {
            res += n - i - 1;
        }
        return res;
    }
};