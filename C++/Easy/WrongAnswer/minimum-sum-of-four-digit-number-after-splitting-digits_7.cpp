class Solution {
public:
    int minimumSum(int num) {
        
        int ans = 0;
        int a = num / 100;
        int b = num % 100;
        ans = min(a, b) + min(a + b, max(a, b));
        return ans;
    }
};