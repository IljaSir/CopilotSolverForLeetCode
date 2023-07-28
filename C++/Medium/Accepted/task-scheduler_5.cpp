class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        
        int count[26] = { 0 };
        for (auto task : tasks) {
            count[task - 'A']++;
        }
        sort(count, count + 26, greater<int>());
        int max_val = count[0] - 1, idle_slots = max_val * n;
        for (int i = 1; i < 26 && count[i] > 0; i++) {
            idle_slots -= min(count[i], max_val);
        }
        return idle_slots > 0 ? idle_slots + tasks.size() : tasks.size();
    }
};