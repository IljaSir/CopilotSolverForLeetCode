class Solution {
public:
    int wordCount(vector<string>& startWords, vector<string>& targetWords) {
        
        int ans = 0;
        for (string& targetWord : targetWords) {
            for (string& startWord : startWords) {
                if (startWord.size() > targetWord.size()) continue;
                int i = 0, j = 0;
                for (; i < startWord.size() && j < targetWord.size(); ++j) {
                    if (startWord[i] == targetWord[j]) ++i;
                }
                if (i == startWord.size()) {
                    ans += 1;
                    break;
                }
            }
        }
        return an
        int res = 0;
        for (auto& target : targetWords) {
            for (auto& start : startWords) {
                if (start.length() < target.length()) {
                    continue;
                }
                vector<int> hash(26, 0);
                for (auto c : target) {
                    hash[c - 'a']++;
                }
                for (auto c : start) {
                    hash[c - 'a']--;
                }
                int count = 0;
                for (auto i : hash) {
                    if (i > 0) {
                        count += i;
                    }
                }
                if (count == 0) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
};