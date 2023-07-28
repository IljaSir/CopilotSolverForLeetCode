class Solution {
public:
    vector<vector<string>> displayTable(vector<vector<string>>& orders) {
        
        map<int, map<string, int>> m;
        set<string> food;
        for (auto order : orders) {
            m[stoi(order[1])][order[2]]++;
            food.insert(order[2]);
        }
        vector<vector<string>> res;
        vector<string> header = {"Table"};
        for (auto f : food) {
            header.push_back(f);
        }
        res.push_back(header);
        for (auto it = m.begin(); it != m.end(); it++) {
            vector<string> row = {to_string(it->first)};
            for (auto f : food) {
                row.push_back(to_string(it->second[f]));
            }
            res.push_back(row);
        }
        return res;
    }
};