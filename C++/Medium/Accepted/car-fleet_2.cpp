class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        
        int n = position.size();
        vector<pair<int, int>> cars;
        for (int i = 0; i < n; ++i) {
            cars.push_back({position[i], speed[i]});
        }
        sort(cars.begin(), cars.end());
        int ans = 0;
        double cur = 0;
        for (int i = n - 1; i >= 0; --i) {
            int p = cars[i].first;
            int s = cars[i].second;
            double t = (double)(target - p) / s;
            if (t > cur) {
                ++ans;
                cur = t;
            }
        }
        return ans;
    }
};