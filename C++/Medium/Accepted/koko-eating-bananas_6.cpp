class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        
        int l = 1, r = 1e9;
        while (l < r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int i = 0; i < piles.size(); i++) {
                cnt += (piles[i] + mid - 1) / mid;
            }
            if (cnt > h) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
};