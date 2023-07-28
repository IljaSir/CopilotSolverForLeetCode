class Solution {
public:
    long long minimumTotalDistance(vector<int>& robot, vector<vector<int>>& factory) {
        
        sort(robot.begin(), robot.end());
        sort(factory.begin(), factory.end(), [](vector<int> &a, vector<int> &b) {
            return a[0] < b[0];
        });
        long long total = 0;
        int f = 0, r = 0, n = robot.size(), m = factory.size();
        while (f < m) {
            int j = f;
            while (j < m && factory[j][0] <= robot[r]) j++;
            if (j == m) {
                total += (long long)(robot[n - 1] - robot[r]) * factory[f][1];
                break;
            }
            int k = r;
            while (k < n && robot[k] < factory[j][0]) k++;
            if (k == n) {
                total += (long long)(robot[r] - robot[0]) * factory[j][1];
                break;
            }
            int x = (k - r) / factory[j][1];
            int y = (n - k) / factory[f][1];
            if (x < y) {
                total += (long long)(robot[k - 1] - robot[r]) * factory[j][1];
                r = k;
                f = j;
            } else {
                total += (long long)(robot[n - 1] - robot[k]) * factory[f][1];
                n = k;
            }
        }
        return total;
    }
};