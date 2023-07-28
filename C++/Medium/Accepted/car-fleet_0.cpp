class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        
        int n = position.size();
        vector<pair<int, int>> cars(n);
        for (int i = 0; i < n; ++i) {
            cars[i] = {position[i], speed[i]};
        }
        sort(cars.begin(), cars.end());
        int ans = 0;
        double cur = 0;
        for (int i = n - 1; i >= 0; --i) {
            double t = (target - cars[i].first) * 1.0 / cars[i].second;
            if (t > cur) {
                ++ans;
                cur = t;
            }
        }
        return ans;
    }
};