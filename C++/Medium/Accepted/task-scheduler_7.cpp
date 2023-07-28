class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        
        int len = tasks.size();
        vector<int> count(26, 0);
        for (char c : tasks)
            ++count[c - 'A'];
        sort(count.begin(), count.end());
        int max_val = count[25] - 1, idle_slots = max_val * n;
        for (int i = 24; i >= 0 && count[i] > 0; --i) {
            idle_slots -= min(count[i], max_val);
        }
        return idle_slots > 0 ? idle_slots + len : len;
    }
};