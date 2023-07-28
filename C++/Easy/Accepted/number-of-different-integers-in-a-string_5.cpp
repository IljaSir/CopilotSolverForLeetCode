class Solution {
public:
    int numDifferentIntegers(string word) {
        
        int n = word.size();
        unordered_set<string> s;
        string t;
        for(int i = 0; i < n; i++){
            if(word[i] >= '0' && word[i] <= '9'){
                t += word[i];
                while(i + 1 < n && word[i + 1] >= '0' && word[i + 1] <= '9'){
                    t += word[i + 1];
                    i++;
                }
                while(t.size() > 1 && t[0] == '0'){
                    t = t.substr(1);
                }
                s.insert(t);
                t = "";
            }
        }
        return s.size();
    }
};