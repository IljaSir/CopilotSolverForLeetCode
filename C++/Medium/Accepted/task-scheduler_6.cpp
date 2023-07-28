class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        
        vector<int> taskCount(26, 0);
        for (auto t : tasks) {
            taskCount[t - 'A']++;
        }
        sort(taskCount.begin(), taskCount.end());
        int maxTaskCount = taskCount[25] - 1;
        int idleSlots = maxTaskCount * n;
        for (int i = 24; i >= 0; i--) {
            idleSlots -= min(taskCount[i], maxTaskCount);
        }
        return idleSlots > 0 ? idleSlots + tasks.size() : tasks.size();
    }
};