class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        
        int l = 1, r = 1e9;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int hours = 0;
            for (auto pile : piles) {
                hours += pile / mid + (pile % mid > 0);
            }
            if (hours > h) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
};