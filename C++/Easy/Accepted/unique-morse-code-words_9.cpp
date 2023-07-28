class Solution {
public:
    int uniqueMorseRepresentations(vector<string>& words) {
        
        std::vector<std::string> morseCodes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        std::unordered_set<std::string> morseSet;
        for (const std::string& word : words) {
            std::string morse = "";
            for (const char c : word) {
                morse += morseCodes[c - 'a'];
            }
            morseSet.insert(morse);
        }
        return morseSet.size();
    }
};