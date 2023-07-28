class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        
        int n = position.size();
        if (n == 0) return 0;
        vector<pair<int, int>> cars;
        for (int i = 0; i < n; ++i) {
            cars.push_back({position[i], speed[i]});
        }
        sort(cars.begin(), cars.end());
        double t = (double)(target - cars[n - 1].first) / cars[n - 1].second;
        int ans = 1;
        for (int i = n - 2; i >= 0; --i) {
            double t1 = (double)(target - cars[i].first) / cars[i].second;
            if (t1 > t) {
                t = t1;
                ++ans;
            }
        }
        return ans;
    }
};