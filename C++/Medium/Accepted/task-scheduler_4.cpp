class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        
        int count[26] = {0};
        for (char c: tasks) {
            count[c - 'A']++;
        }
        std::sort(count, count + 26);
        int max_val = count[25] - 1, idle_slots = max_val * n;
        for (int i = 24; i >= 0 && count[i] > 0; i--) {
            idle_slots -= std::min(count[i], max_val);
        }
        return idle_slots > 0 ? idle_slots + tasks.size() : tasks.size();
    }
};