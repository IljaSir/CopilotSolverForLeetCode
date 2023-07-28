class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        
        int max = 0;
        for (int i = 0; i < piles.size(); i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }
        int min = 1;
        int mid = 0;
        while (min < max) {
            mid = min + (max - min) / 2;
            int hours = 0;
            for (int i = 0; i < piles.size(); i++) {
                hours += piles[i] / mid;
                if (piles[i] % mid != 0) {
                    hours++;
                }
            }
            if (hours > h) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }
};