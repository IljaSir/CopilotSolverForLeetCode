class Solution {
public:
    int mostWordsFound(vector<string>& sentences) {
        
        int max = 0;
        for (int i = 0; i < sentences.size(); i++) {
            int count = 0;
            for (int j = 0; j < sentences[i].size(); j++) {
                if (sentences[i][j] == ' ') {
                    count++;
                }
            }
            if (max < count) {
                max = count;
            }
        }
        return max;
    }
    int maxNumberOfWordsFound(string sentence) {
        int count = 0;
        for (int i = 0; i < sentence.size(); i++) {
            if (sentence[i] == ' ') {
                count++;
            }
        }
        return count;
    }
    int maxWords(vector<string>& sentences) {
        int max = 0;
        for (int i = 0; i < sentences.size(); i++) {
            int count = maxNumberOfWordsFound(sentences[i]);
            if (max < count) {
                max = count;
            }
        }
        return max;
    }
    int maxNumberOfWords(string sentence) {
        int count = 0;
        for (int i = 0; i < sentence.size(); i++) {
            if (sentence[i] == ' ') {
                count++;
            }
        }
        return count;
    }
    int maxNumberOfWordsInSentence(string sentence) {
        int count = 0;
        for (int i = 0; i < sentence.size(); i++) {
            if (sentence[i] == ' ') {
                count++;
            }
        }
        return count;
    }
    int maxNumberOfWordsInSentences(vector<string>& sentences) {
        int max = 0;
        for (int i = 0; i < sentences.size(); i++) {
            int count = maxNumberOfWordsInSentence(sentences[i]);
            if (max < count) {
                max = count;
            }
        }
        return max;
    }
    int maxNumberOfWordsInSentence(string sentence) {
        int count = 0;
        for (int i = 0; i < sentence.size(); i++) {
            if (sentence[i] == ' ') {
                count++;
            }
        }
        return count;
    }
};