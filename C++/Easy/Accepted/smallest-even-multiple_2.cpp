class Solution {
public:
    int smallestEvenMultiple(int n) {
        
        int ans = n;
        while (ans % 2 != 0) {
            ans += n;
        }
        return ans;
    }
};