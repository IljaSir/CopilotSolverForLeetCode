class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        
        int count[26] = {0};
        for (char ch : tasks) {
            count[ch - 'A']++;
        }
        sort(count, count + 26);
        int max_val = count[25] - 1;
        int idle_slots = max_val * n;
        for (int i = 24; i >= 0 && count[i] > 0; i--) {
            idle_slots -= min(count[i], max_val);
        }
        return idle_slots > 0 ? idle_slots + tasks.size() : tasks.size();
    }
};