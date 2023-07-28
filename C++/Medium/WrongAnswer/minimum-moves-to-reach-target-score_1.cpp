class Solution {
public:
    int minMoves(int target, int maxDoubles) {
        
        int ans = 0;
        while (target > 1) {
            ans++;
            target = (target + 1) / 2;
        }
        return ans;
    }
};