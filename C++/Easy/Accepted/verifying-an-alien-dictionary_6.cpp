class Solution {
public:
    bool isAlienSorted(vector<string>& words, string order) {
        
        for(int i=0; i<words.size()-1; i++){
            for(int j=0; j<words[i].size(); j++){
                if(j >= words[i+1].size()) return false;
                if(words[i][j] == words[i+1][j]) continue;
                if(order.find(words[i][j]) > order.find(words[i+1][j])) return false;
                break;
            }
        }
        return true;
    }
};