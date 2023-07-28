class Solution {
public:
    int canBeTypedWords(string text, string brokenLetters) {
        
        unordered_set<char> broken(brokenLetters.begin(), brokenLetters.end());
        istringstream iss(text);
        string word;
        int count = 0;
        while (iss >> word) {
            bool good = true;
            for (char c: word) {
                if (broken.count(c)) {
                    good = false;
                    break;
                }
            }
            if (good) count++;
        }
        return count;
    }
};