class Solution {
public:
    int minimumRounds(vector<int>& tasks) {
        
        unordered_map<int, int> freq;
        for (int t : tasks) {
            freq[t]++;
        }
        int ans = 0;
        for (auto& [k, v] : freq) {
            int n = v / 3;
            ans += n;
            v %= 3;
            if (v == 1) {
                freq[k + 1]++;
            } else if (v == 2) {
                freq[k + 1]++;
                freq[k + 2]++;
            }
        }
        for (auto& [k, v] : freq) {
            if (v > 0) {
                ans += (v + 2) / 3;
            }
        }
        return ans;
    }
};