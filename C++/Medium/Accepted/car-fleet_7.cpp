class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        
        int n = position.size();
        vector<pair<int, int>> cars;
        for (int i = 0; i < n; ++i)
            cars.push_back(make_pair(position[i], speed[i]));
        sort(cars.begin(), cars.end());
        int res = 0;
        double t = 0.0;
        for (int i = n - 1; i >= 0; --i) {
            double nt = (target - cars[i].first) * 1.0 / cars[i].second;
            if (nt > t) {
                t = nt;
                ++res;
            }
        }
        return res;
    }
};