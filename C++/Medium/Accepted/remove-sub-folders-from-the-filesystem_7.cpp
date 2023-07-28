class Solution {
public:
    vector<string> removeSubfolders(vector<string>& folder) {
        
        vector<string> res;
        sort(folder.begin(), folder.end());
        string prev = " ";
        for (auto f : folder) {
            if (f.find(prev) != 0) {
                res.push_back(f);
                prev = f + "/";
            }
        }
        return res;
    }
};