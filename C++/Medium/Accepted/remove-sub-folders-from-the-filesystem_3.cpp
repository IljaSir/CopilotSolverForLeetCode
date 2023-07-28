class Solution {
public:
    vector<string> removeSubfolders(vector<string>& folder) {
        
        sort(folder.begin(), folder.end());
        vector<string> res;
        res.push_back(folder[0]);
        for(int i = 1; i < folder.size(); i++){
            if(folder[i].substr(0, res.back().size()) != res.back() || folder[i][res.back().size()] != '/')
                res.push_back(folder[i]);
        }
        return res;
    }
};