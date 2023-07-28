class Solution {
public:
    int shipWithinDays(vector<int>& weights, int days) {
        
        int n = weights.size();
        int maxWeight = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += weights[i];
            maxWeight = max(maxWeight, weights[i]);
        }
        int left = maxWeight;
        int right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int need = 1;
            int cur = 0;
            for (int i = 0; i < n; i++) {
                if (cur + weights[i] > mid) {
                    need++;
                    cur = 0;
                }
                cur += weights[i];
            }
            if (need <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
};