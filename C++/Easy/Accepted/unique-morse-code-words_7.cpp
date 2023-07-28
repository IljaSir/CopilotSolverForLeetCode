class Solution {
public:
    int uniqueMorseRepresentations(vector<string>& words) {
        
        unordered_set<string> s;
        string morse[26] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for (auto w : words) {
            string t;
            for (auto c : w) {
                t += morse[c - 'a'];
            }
            s.insert(t);
        }
        return s.size();
    }
};