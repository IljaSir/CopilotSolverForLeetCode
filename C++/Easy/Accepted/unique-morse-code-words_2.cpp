class Solution {
public:
    int uniqueMorseRepresentations(vector<string>& words) {
        
        string morse[26] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        unordered_set<string> s;
        for (string w: words) {
            string t;
            for (char c: w) {
                t += morse[c - 'a'];
            }
            s.insert(t);
        }
        return s.size();
    }
};