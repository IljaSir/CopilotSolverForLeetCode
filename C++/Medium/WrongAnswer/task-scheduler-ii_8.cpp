class Solution {
public:
    long long taskSchedulerII(vector<int>& tasks, int space) {
        
        int n = tasks.size();
        vector<pair<int, int>> task_cnt;
        for (int i = 0; i < n; ++i) {
            bool found = false;
            for (auto& [task, cnt] : task_cnt) {
                if (task == tasks[i]) {
                    found = true;
                    ++cnt;
                    break;
                }
            }
            if (!found) {
                task_cnt.push_back({tasks[i], 1});
            }
        }
        sort(task_cnt.begin(), task_cnt.end(), [](const auto& a, const auto& b) {
            return a.second > b.second;
        });
        int max_cnt = task_cnt[0].second;
        int max_cnt_cnt = 0;
        for (auto& [task, cnt] : task_cnt) {
            if (cnt == max_cnt) {
                ++max_cnt_cnt;
            } else {
                break;
            }
        }
        return max((long long)n, (long long)(max_cnt - 1) * (space + 1) + max_cnt_cnt);
    }
};