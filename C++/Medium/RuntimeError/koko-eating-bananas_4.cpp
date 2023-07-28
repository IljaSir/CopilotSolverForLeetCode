class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        
        int max = 0;
        int sum = 0;
        for (int i = 0; i < piles.size(); i++) {
            if (max < piles[i]) {
                max = piles[i];
            }
            sum += piles[i];
        }
        int min = sum / h;
        if (min < 1) {
            min = 1;
        }
        if (min > max) {
            return max;
        }
        int mid = (min + max) / 2;
        while (min < max) {
            int time = 0;
            for (int i = 0; i < piles.size(); i++) {
                time += piles[i] / mid;
                if (piles[i] % mid != 0) {
                    time++;
                }
            }
            if (time > h) {
                min = mid + 1;
            } else {
                max = mid;
            }
            mid = (min + max) / 2;
        }
        return mid;
    }
};