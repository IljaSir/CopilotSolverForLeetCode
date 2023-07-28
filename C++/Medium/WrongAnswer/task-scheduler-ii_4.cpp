class Solution {
public:
    long long taskSchedulerII(vector<int>& tasks, int space) {
        
        int n = tasks.size();
        int maxFreq = 0;
        unordered_map<int, int> freq;
        for (int x : tasks) {
            freq[x]++;
            maxFreq = max(maxFreq, freq[x]);
        }
        int maxCount = 0;
        for (auto [_, cnt] : freq) {
            if (cnt == maxFreq) {
                maxCount++;
            }
        }
        return max((long long)n, (long long)(maxFreq - 1) * (space + 1) + maxCount);
    }
};