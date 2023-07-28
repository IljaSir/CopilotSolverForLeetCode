class Solution {
public:
    int minMoves(int target, int maxDoubles) {
        
        int ans = 0;
        while (target > 1) {
            if (target & 1) {
                target--;
                ans++;
            } else {
                if (maxDoubles > 0) {
                    maxDoubles--;
                    target >>= 1;
                    ans++;
                } else {
                    target--;
                    ans++;
                }
            }
        }
        return ans;
    }
};