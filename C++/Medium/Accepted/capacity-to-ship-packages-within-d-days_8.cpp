class Solution {
public:
    int shipWithinDays(vector<int>& weights, int days) {
        
        long sum = 0;
        int max = 0;
        for (int i = 0; i < weights.size(); i++) {
            sum += weights[i];
            max = std::max(max, weights[i]);
        }
        long l = max, r = sum;
        while (l < r) {
            long mid = l + (r - l) / 2;
            if (canShip(weights, days, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    
    bool canShip(vector<int>& weights, int days, int cap) {
        int count = 1;
        int sum = 0;
        for (int i = 0; i < weights.size(); i++) {
            sum += weights[i];
            if (sum > cap) {
                sum = weights[i];
                count++;
                if (count > days) {
                    return false;
                }
            }
        }
        return true;
    }
};