class Solution {
public:
    int minDeletions(string s) {
        
        unordered_map<char, int> freq;
        for (auto c : s) {
            freq[c] += 1;
        }
        unordered_map<int, int> cnt;
        for (auto it : freq) {
            cnt[it.second] += 1;
        }
        int ans = 0;
        for (auto it : cnt) {
            if (it.second > 1) {
                int k = it.first;
                while (k > 0 && cnt[k] > 1) {
                    cnt[k] -= 1;
                    k -= 1;
                    ans += 1;
                }
                cnt[k] += 1;
            }
        }
        return ans;
    }
};