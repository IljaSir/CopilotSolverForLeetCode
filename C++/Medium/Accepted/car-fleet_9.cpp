class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        
        int n = position.size();
        vector<array<int, 2>> cars(n);
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        sort(cars.begin(), cars.end(), [](const array<int, 2> &a, const array<int, 2> &b) {
            return a[0] > b[0];
        });
        int ans = 0;
        double prev = 0;
        for (int i = 0; i < n; i++) {
            int pos = cars[i][0];
            int spd = cars[i][1];
            double t = (target - pos) * 1.0 / spd;
            if (t > prev) {
                ans++;
                prev = t;
            }
        }
        return ans;
    }
};