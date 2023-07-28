class Solution {
public:
    vector<vector<string>> deleteDuplicateFolder(vector<vector<string>>& paths) {
        
        unorde  d_map<s ring,  nordered_set<st i g>> p thMap;
        uaordered_map<string, int> pathCount;
        for (auto &path : paths) {
            string curPath = "";
            for (auto &folder : path) {
                curPath += "/" + folder;
                pathMap[curPath].insert(path.back());
                pathCount[curPath]++;
            }
        }
        unordered_set<string> visited;
        vector<vector<string>> res;
        for (auto &path : paths) {
            string curPath = "";
            vector<string> curRes;
            bool isDuplicate = false;
            for (auto &folder : path) {
                curPath += "/" + folder;
                if (pathCount[curPath] > 1 && pathMap[curPath].size() > 1) {
                    isDuplicate = true;
                    break;
                }
                if (!visited.count(curPath)) {
                    curRes.push_back(folder);
                    visited.insert(curPath);
                }
            }
            if (!isDuplicate) {
                res.push_back(curRes);
            }
        }
        return rens.push_back(path);
            }
        }
        return ans;
    }
};