class Solution {
public:
    int minimumRounds(vector<int>& tasks) {
        
        unordered_map<int, int> taskMap;
        for (auto task: tasks) {
            taskMap[task]++;
        }
        int res = 0;
        int left = 0;
        for (auto it = taskMap.begin(); it != taskMap.end(); it++) {
            int task = it->first;
            int cnt = it->second;
            if (left > 0) {
                if (left % 2 == 1) {
                    if (cnt >= 2) {
                        cnt -= 2;
                        left = 0;
                    } else {
                        cnt = 0;
                        left = 1;
                    }
                } else {
                    if (cnt >= 1) {
                        cnt -= 1;
                        left = 0;
                    } else {
                        cnt = 0;
                        left = 1;
                    }
                }
            }
            res += cnt / 3;
            left += cnt % 3;
        }
        if (left > 0) {
            res++;
        }
        return res;
    }
};