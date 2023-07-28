class Solution {
public:
    int uniqueMorseRepresentations(vector<string>& words) {
        
        string map[26] = { ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.." };
        set<string> s;
        for (auto w : words) {
            string m;
            for (auto c : w) {
                m += map[c - 'a'];
            }
            s.insert(m);
        }
        return s.size();
    }
};