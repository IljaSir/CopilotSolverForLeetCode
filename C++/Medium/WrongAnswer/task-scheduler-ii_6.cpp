class Solution {
public:
    long long taskSchedulerII(vector<int>& tasks, int space) {
        
        int n = tasks.size();
        vector<pair<int, int>> taskCount;
        unordered_map<int, int> taskMap;
        for (int task : tasks) {
            taskMap[task]++;
        }
        for (auto &p : taskMap) {
            taskCount.push_back({p.second, p.first});
        }
        sort(taskCount.begin(), taskCount.end(), greater<pair<int, int>>());
        int maxCount = taskCount[0].first;
        int maxTask = taskCount[0].second;
        int maxCountCount = 0;
        for (auto &p : taskCount) {
            if (p.first == maxCount) {
                maxCountCount++;
            }
        }
        int maxSpace = (maxCount - 1) * (space + 1) + maxCountCount;
        int minSpace = n;
        return max(minSpace, maxSpace);
    }
};