class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        
        int left = 1, right = 0;
        for (int pile : piles) {
            right = max(right, pile);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int hours = 0;
            for (int pile : piles) {
                hours += (pile - 1) / mid + 1;
            }
            if (hours > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
};