class Solution {
public:
    vector<int> numSmallerByFrequency(vector<string>& queries, vector<string>& words) {
        
        vector<int> res;
        for(auto& q: queries){
            int count = 0;
            for(auto& w: words){
                if(frequency(q) < frequency(w)){
                    count++;
                }
            }
            res.push_back(count);
        }
        return res;
    }
    
    int frequency(string& s){
        int count = 0;
        char c = 'z';
        for(auto& ch: s){
            if(c > ch){
                c = ch;
                count = 1;
            }else if(c == ch){
                count++;
            }
        }
        return count;
    }
};