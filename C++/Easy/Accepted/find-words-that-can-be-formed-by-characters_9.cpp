class Solution {
public:
    int countCharacters(vector<string>& words, string chars) {
        
        int count = 0;
        for (auto word: words) {
            string tmp = chars;
            bool isGood = true;
            for (auto w: word) {
                auto pos = tmp.find(w);
                if (pos != string::npos) {
                    tmp.erase(pos, 1);
                } else {
                    isGood = false;
                    break;
                }
            }
            if (isGood) {
                count += word.length();
            }
        }
        return count;
    }
};