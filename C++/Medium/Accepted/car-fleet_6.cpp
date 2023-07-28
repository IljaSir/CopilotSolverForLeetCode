class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        
        int n = position.size();
        if (n == 1) return 1;
        vector<pair<int, int>> cars;
        for (int i = 0; i < n; ++i) {
            cars.push_back({position[i], speed[i]});
        }
        sort(cars.begin(), cars.end());
        vector<double> times;
        for (int i = 0; i < n; ++i) {
            times.push_back((target - cars[i].first) * 1.0 / cars[i].second);
        }
        int cnt = 1;
        double max_time = times[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            if (times[i] > max_time) {
                ++cnt;
                max_time = times[i];
            }
        }
        return cnt;
    }
};