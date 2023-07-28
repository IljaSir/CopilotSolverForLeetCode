class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        
        int l = 1, r = 1e9;
        while (l < r) {
            int mid = (l + r) / 2;
            int time = 0;
            for (int pile : piles) {
                time += (pile - 1) / mid + 1;
            }
            if (time <= h) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
};