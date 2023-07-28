class Solution {
public:
    int countCharacters(vector<string>& words, string chars) {
        
        int counter = 0;
        for (int i = 0; i < words.size(); i++) {
            string word = words[i];
            string charCopy = chars;
            bool isGood = true;
            for (int j = 0; j < word.size(); j++) {
                int index = charCopy.find(word[j]);
                if (index == string::npos) {
                    isGood = false;
                    break;
                }
                charCopy.erase(index, 1);
            }
            if (isGood) {
                counter += word.size();
            }
        }
        return counter;
    }
};