class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        
        int n = position.size();
        vector<pair<int, int>> cars;
        for (int i = 0; i < n; ++i) {
            cars.push_back({position[i], speed[i]});
        }
        sort(cars.begin(), cars.end(), [](const pair<int, int>& a, const pair<int, int>& b) {
            return a.first > b.first;
        });
        int fleet = 0;
        double cur = 0;
        for (int i = 0; i < n; ++i) {
            double t = 1.0 * (target - cars[i].first) / cars[i].second;
            if (t > cur) {
                ++fleet;
                cur = t;
            }
        }
        return fleet;
    }
};