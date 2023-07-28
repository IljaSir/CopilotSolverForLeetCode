class Solution {
public:
    int wordCount(vector<string>& startWords, vector<string>& targetWords) {
        
        int ans = 0;
        for (auto& target : targetWords) {
            for (auto& start : startWords) {
                if (target.size() == start.size()) {
                    int cnt = 0;
                    for (int i = 0; i < target.size(); ++i) {
                        if (target[i] != start[i]) {
                            ++cnt;
                            if (cnt > 1) {
                                break;
                            }
                        }
                    }
                    if (cnt == 1) {
                        ++ans;
                        break;
                    }
                }
            }
        }
        return ans;
    }
    int countConsistentStrings(string allowed, vector<string>& words) {
        int ans = 0;
        for (auto& word : words) {
            bool ok = true;
            for (auto& ch : word) {
                if (allowed.find(ch) == string::npos) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                ++ans;
            }
        }
        return ans;
    }
};