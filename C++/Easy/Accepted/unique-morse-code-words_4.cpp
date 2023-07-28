class Solution {
public:
    int uniqueMorseRepresentations(vector<string>& words) {
        
        vector<string> morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        unordered_set<string> s;
        for (string word : words) {
            string morse = "";
            for (char ch : word) {
                morse += morseCode[ch - 'a'];
            }
            s.insert(morse);
        }
        return s.size();
    }
};