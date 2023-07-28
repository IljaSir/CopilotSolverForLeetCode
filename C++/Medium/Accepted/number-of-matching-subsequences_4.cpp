class Solution {
public:
    int numMatchingSubseq(string s, vector<string>& words) {
        
        int res = 0;
        vector<vector<int>> pos(26);
        for(int i = 0; i < s.size(); i++){
            pos[s[i] - 'a'].push_back(i);
        }
        for(auto &word : words){
            int pre = -1;
            bool flag = true;
            for(auto &c : word){
                auto it = upper_bound(pos[c - 'a'].begin(), pos[c - 'a'].end(), pre);
                if(it == pos[c - 'a'].end()){
                    flag = false;
                    break;
                }
                pre = *it;
            }
            if(flag) res++;
        }
        return res;
    }
};