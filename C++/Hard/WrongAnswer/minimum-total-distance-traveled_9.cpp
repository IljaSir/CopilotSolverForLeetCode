class Solution {
public:
    long long minimumTotalDistance(vector<int>& robot, vector<vector<int>>& factory) {
        
        long long res = 0;
        vector<int> factoryPos;
        vector<int> factoryLimit;
        for (auto &f : factory) {
            factoryPos.push_back(f[0]);
            factoryLimit.push_back(f[1]);
        }
        sort(factoryPos.begin(), factoryPos.end());
        sort(factoryLimit.begin(), factoryLimit.end());
        sort(robot.begin(), robot.end());
        for (int i = 0; i < robot.size(); i++) {
            int l = 0, r = factoryPos.size() - 1;
            while (l < r) {
                int mid = (l + r) / 2;
                if (robot[i] < factoryPos[mid]) {
                    r = mid;
                } else if (robot[i] > factoryPos[mid]) {
                    l = mid + 1;
                } else {
                    l = mid;
                    break;
                }
            }
            int left = l, right = l;
            while (left > 0 && factoryLimit[left - 1] == factoryLimit[left]) {
                left--;
            }
            while (right < factoryLimit.size() - 1 && factoryLimit[right + 1] == factoryLimit[right]) {
                right++;
            }
            int minD = robot[i] - factoryPos[left];
            int minI = left;
            for (int j = left + 1; j <= right; j++) {
                if (robot[i] - factoryPos[j] < minD) {
                    minD = robot[i] - factoryPos[j];
                    minI = j;
                }
            }
            res += minD;
            factoryLimit[minI]--;
        }
        return res;
    }
};