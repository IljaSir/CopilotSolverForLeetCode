class Solution {
public:
    int wordCount(vector<string>& startWords, vector<string>& targetWords) {
        
        int ans = 0;
        for (auto& target: targetWords) {
            unordered_set<char> targetSet;
            for (char c: target) {
                targetSet.insert(c);
            }
            bool found = false;
            for (auto& start: startWords) {
                if (start.length() < target.length()) {
                    continue;
                }
                unordered_set<char> startSet;
                for (char c: start) {
                    startSet.insert(c);
                }
                bool flag = true;
                for (char c: targetSet) {
                    if (startSet.find(c) == startSet.end()) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    found = true;
                    break;
                }
            }
            if (found) {
                ans++;
            }
        }
        return ans;
    }
};