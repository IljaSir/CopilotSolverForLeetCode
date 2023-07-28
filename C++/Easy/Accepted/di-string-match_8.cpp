class Solution {
public:
    vector<int> diStringMatch(string s) {
        
        int n = s.size();
        vector<int> res;
        int min = 0, max = n;
        for(int i = 0; i < n; i++){
            if(s[i] == 'I'){
                res.push_back(min);
                min++;
            }
            else{
                res.push_back(max);
                max--;
            }
        }
        res.push_back(min);
        return res;
    }
};