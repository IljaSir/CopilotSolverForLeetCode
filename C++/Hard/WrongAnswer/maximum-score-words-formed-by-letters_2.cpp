class Solution {
public:
    int maxScoreWords(vector<string>& words, vector<char>& letters, vector<int>& score) {
        
        unordered_map<char, int> letterCount;
        for (auto c : letters) {
            letterCount[c]++;
        }
        return maxScoreWords(words, 0, letterCount, score);
    }
    int maxScoreWords(vector<string>& words, int idx, unordered_map<char, int> letterCount, vector<int>& score) {
        if (idx == words.size()) {
            return 0;
        }
        int maxScore = 0;
        int wordScore = 0;
        bool canFormWord = true;
        for (auto c : words[idx]) {
            if (letterCount[c] == 0) {
                canFormWord = false;
                break;
            }
            letterCount[c]--;
            wordScore += score[c - 'a'];
        }
        if (canFormWord) {
            maxScore = wordScore + maxScoreWords(words, idx + 1, letterCount, score);
        }
        maxScore = max(maxScore, maxScoreWords(words, idx + 1, letterCount, score));
        return maxScore;
    }
};