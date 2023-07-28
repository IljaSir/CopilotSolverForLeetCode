class Solution {
public:
    int minDeletions(string s) {
        
        unordered_map<char, int> freq;
        for (auto ch : s) {
            freq[ch]++;
        }
        unordered_set<int> used;
        int ans = 0;
        for (auto& [_, count] : freq) {
            while (count > 0 && used.count(count)) {
                count--;
                ans++;
            }
            used.insert(count);
        }
        return ans;
    }
};