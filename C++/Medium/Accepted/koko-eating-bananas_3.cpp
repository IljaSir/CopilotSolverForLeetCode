class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        
        int lo = 1, hi = 1e9;
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            int time = 0;
            for (int p : piles) {
                time += (p - 1) / mi + 1;
            }
            if (time > h) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return lo;
    }
};