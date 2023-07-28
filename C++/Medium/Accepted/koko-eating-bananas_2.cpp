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
        while (min < max) {
            int mid = (min + max) / 2;
            int time = 0;
            for (int i = 0; i < piles.size(); i++) {
                time += piles[i] / mid;
                if (piles[i] % mid != 0) {
                    time++;
                }
            }
            if (time <= h) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
};