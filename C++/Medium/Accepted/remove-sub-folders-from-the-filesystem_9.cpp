class Solution {
public:
    vector<string> removeSubfolders(vector<string>& folder) {
        
        sort(folder.begin(), folder.end());
        vector<string> r;
        for(auto f : folder)
            if(r.empty() || r.back().size() > f.size() || r.back() != f.substr(0, r.back().size()) || f[r.back().size()] != '/')
                r.push_back(f);
        return r;
    }
};