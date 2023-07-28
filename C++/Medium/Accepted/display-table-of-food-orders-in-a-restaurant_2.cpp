class Solution {
public:
    vector<vector<string>> displayTable(vector<vector<string>>& orders) {
        
        map<int, map<string, int>> table;
        set<string> food;
        for (auto &order : orders) {
            table[stoi(order[1])][order[2]]++;
            food.insert(order[2]);
        }
        vector<vector<string>> res;
        vector<string> header;
        header.push_back("Table");
        for (auto &f : food) {
            header.push_back(f);
        }
        res.push_back(header);
        for (auto &t : table) {
            vector<string> row;
            row.push_back(to_string(t.first));
            for (auto &f : food) {
                row.push_back(to_string(t.second[f]));
            }
            res.push_back(row);
        }
        return res;
    }
};