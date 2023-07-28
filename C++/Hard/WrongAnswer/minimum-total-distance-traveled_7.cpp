class Solution {
public:
    long long minimumTotalDistance(vector<int>& robot, vector<vector<int>>& factory) {
        
        sort(robot.begin(), robot.end());
        vector<int> factoryPos;
        for (auto& f : factory) {
            factoryPos.push_back(f[0]);
        }
        sort(factoryPos.begin(), factoryPos.end());
        vector<int> factoryCnt(factory.size());
        int i = 0, j = 0;
        long long ans = 0;
        for (int robotPos : robot) {
            while (j < factoryPos.size() && robotPos > factoryPos[j]) {
                j++;
            }
            if (j == factoryPos.size()) {
                ans += robotPos - factoryPos[j - 1];
                factoryCnt[j - 1]++;
            } else if (j == 0) {
                ans += factoryPos[j] - robotPos;
                factoryCnt[j]++;
            } else {
                if (robotPos - factoryPos[j - 1] <= factoryPos[j] - robotPos) {
                    ans += robotPos - factoryPos[j - 1];
                    factoryCnt[j - 1]++;
                } else {
                    ans += factoryPos[j] - robotPos;
                    factoryCnt[j]++;
                }
            }
        }
        for (int i = 0; i < factory.size(); i++) {
            if (factory[i][1] < factoryCnt[i]) {
                ans += factoryCnt[i] - factory[i][1];
            }
        }
        return ans;
    }
};