class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        
        int n = position.size();
        vector<pair<int, int>> cars;
        for (int i = 0; i < n; i++) {
            cars.push_back({position[i], speed[i]});
        }
        sort(cars.begin(), cars.end());
        int fleets = 0;
        double time = 0;
        for (int i = n - 1; i >= 0; i--) {
            double t = (target - cars[i].first) * 1.0 / cars[i].second;
            if (t > time) {
                fleets++;
                time = t;
            }
        }
        return fleets;
    }
};