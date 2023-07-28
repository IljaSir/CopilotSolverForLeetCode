class Solution {
public:
    long long minimumTotalDistance(vector<int>& robot, vector<vector<int>>& factory) {
        
        int n = robot.size();
        int m = factory.size();
        long long res = 0;
        sort(robot.begin(), robot.end());
        for (auto& f: factory) {
            int pos = f[0];
            int limit = f[1];
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (robot[mid] >= pos) r = mid;
                else l = mid + 1;
            }
            int cnt = 0;
            if (robot[l] > pos) {
                if (l < n) {
                    if (cnt < limit) {
                        cnt++;
                        res += robot[l] - pos;
                    }
                    l++;
                }
            } else {
                if (l > 0) {
                    if (cnt < limit) {
                        cnt++;
                        res += pos - robot[l - 1];
                    }
                    l--;
                }
            }
            while (cnt < limit && l >= 0 && l < n) {
                cnt++;
                res += abs(robot[l] - pos);
                l++;
            }
        }
        return res;
    }
};