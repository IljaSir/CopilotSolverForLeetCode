class Solution {
public:
    int countWords(vector<string>& words1, vector<string>& words2) {
        
        unordered_map<string, int> m1;
        unordered_map<string, int> m2;
        for (auto& w : words1) {
            m1[w]++;
        }
        for (auto& w : words2) {
            m2[w]++;
        }
        int ans = 0;
        for (auto& p : m1) {
            if (p.second == 1 && m2.count(p.first) == 0) {
                ans++;
            }
        }
        for (auto& p : m2) {
            if (p.second == 1 && m1.count(p.first) == 0) {
                ans++;
            }
        }
        return ans;
    }
};