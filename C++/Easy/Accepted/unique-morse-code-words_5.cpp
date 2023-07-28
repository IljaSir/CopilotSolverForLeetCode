class Solution {
public:
    int uniqueMorseRepresentations(vector<string>& words) {
        
        string morse[26] = {
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };
        unordered_set<string> set;
        for (auto word : words) {
            string code;
            for (auto c : word) {
                code += morse[c - 'a'];
            }
            set.insert(code);
        }
        return set.size();
    }
};