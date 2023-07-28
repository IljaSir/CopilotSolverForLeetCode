class Solution {
public:
    int maxScoreWords(vector<string>& words, vector<char>& letters, vector<int>& score) {
        
        map<char, int> letterCount;
        for (auto c : letters) {
            letterCount[c]++;
        }
        return maxScore(words, letterCount, score);
    }
    
    int maxScore(vector<string>& words, map<char, int>& letterCount, vector<int>& score) {
        int maxScore = 0;
        for (int i = 0; i < words.size(); i++) {
            string word = words[i];
            map<char, int> wordCount;
            for (auto c : word) {
                wordCount[c]++;
            }
            bool canForm = true;
            for (auto c : word) {
                if (wordCount[c] > letterCount[c]) {
                    canForm = false;
                    break;
                }
            }
            if (canForm) {
                for (auto c : word) {
                    letterCount[c]--;
                }
                words.erase(words.begin() + i);
                int score = maxScore(words, letterCount, score);
                for (auto c : word) {
                    letterCount[c]++;
                }
                words.insert(words.begin() + i, word);
                maxScore = max(maxScore, score);
            }
        }
        int score = 0;
        for (auto c : letterCount) {
            score += c.second * score[c.first - 'a'];
        }
        return max(maxScore, score);
    }
};