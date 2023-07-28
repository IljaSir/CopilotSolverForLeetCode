class Solution {
public:
    int uniqueMorseRepresentations(vector<string>& words) {
        
        string morse[26] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        map<string,int> mp;
        for(int i=0;i<words.size();i++){
            string str = "";
            for(int j=0;j<words[i].length();j++){
                str += morse[words[i][j] - 'a'];
            }
            mp[str]++;
        }
        return mp.size();
    }
};