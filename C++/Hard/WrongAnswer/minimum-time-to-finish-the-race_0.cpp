class Solution {
public:
    int minimumFinishTime(vector<vector<int>>& tires, int changeTime, int numLaps) {
        
        int n = tires.size();
        vector<pair<int, int>> tire(n);
        for (int i = 0; i < n; i++) {
            tire[i] = {tires[i][0], tires[i][1]};
        }
        sort(tire.begin(), tire.end(), [](pair<int, int> &a, pair<int, int> &b) {
            return a.first * b.second < b.first * a.second;
        });
        long long ans = 1e18;
        for (int i = 0; i < n; i++) {
            long long sum = 0;
            for (int j = 0; j < n; j++) {
                int k = (i + j) % n;
                long long t = tire[k].first * pow(tire[k].second, numLaps - 1);
                sum += t;
                if (j != n - 1) sum += changeTime;
            }
            ans = min(ans, sum);
        }
        return ans;
    }
};