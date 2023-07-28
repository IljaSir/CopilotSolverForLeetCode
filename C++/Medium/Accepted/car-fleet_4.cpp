class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        
        int n = position.size();
        vector<pair<int, int>> cars(n);
        for (int i = 0; i < n; ++i) {
            cars[i] = make_pair(position[i], speed[i]);
        }
        sort(cars.begin(), cars.end(), [](pair<int, int>& a, pair<int, int>& b) {
            return a.first > b.first;
        });
        double t = 0;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (cars[i].second * t < target - cars[i].first) {
                t = 1.0 * (target - cars[i].first) / cars[i].second;
                ++ans;
            }
        }
        return ans;
    }
};