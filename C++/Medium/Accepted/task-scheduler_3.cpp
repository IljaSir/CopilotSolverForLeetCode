class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        
        vector<int> freq(26, 0);
        for (auto task : tasks) {
            freq[task - 'A']++;
        }
        sort(freq.begin(), freq.end());
        int max_freq = freq[25] - 1;
        int idle_slots = max_freq * n;
        for (int i = 24; i >= 0 && freq[i] > 0; i--) {
            idle_slots -= min(freq[i], max_freq);
        }
        return idle_slots > 0 ? idle_slots + tasks.size() : tasks.size();
    }
};