class Solution {
public:
    int minimumRounds(vector<int>& tasks) {
        
        map<int, int> taskMap;
        for (auto task : tasks) {
            taskMap[task]++;
        }
        int round = 0;
        for (auto it = taskMap.begin(); it != taskMap.end(); it++) {
            int task = it->first;
            int count = it->second;
            if (count % 2 == 1) {
                if (taskMap[task + 1] > 0) {
                    taskMap[task + 1]--;
                    count++;
                } else {
                    return -1;
                }
            }
            round += count / 2;
        }
        return round;
    }
};