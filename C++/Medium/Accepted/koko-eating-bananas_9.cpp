class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        
        int max_pile = 0;
        for (auto p : piles) {
            max_pile = max(max_pile, p);
        }
        int min_k = 1;
        int max_k = max_pile;
        while (min_k < max_k) {
            int mid_k = min_k + (max_k - min_k) / 2;
            int hours = 0;
            for (auto p : piles) {
                hours += p / mid_k;
                if (p % mid_k != 0) {
                    hours++;
                }
            }
            if (hours <= h) {
                max_k = mid_k;
            } else {
                min_k = mid_k + 1;
            }
        }
        return min_k;
    }
};