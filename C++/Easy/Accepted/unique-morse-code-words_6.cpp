class Solution {
public:
    int uniqueMorseRepresentations(vector<string>& words) {
        
        vector<string> morse_code = {
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };
        set<string> s;
        for (auto w: words) {
            string code;
            for (auto c: w) {
                code += morse_code[c - 'a'];
            }
            s.insert(code);
        }
        return s.size();
    }
};