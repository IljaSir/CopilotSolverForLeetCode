class Solution {
public:
    vector<vector<string>> displayTable(vector<vector<string>>& orders) {
        
        vector<vector<string>> ret;
        map<int, map<string, int>> table;
        set<string> food;
        for (auto v : orders) {
            int t = stoi(v[1]);
            string f = v[2];
            table[t][f]++;
            food.insert(f);
        }
        vector<string> header;
        header.push_back("Table");
        for (auto f : food) {
            header.push_back(f);
        }
        ret.push_back(header);
        for (auto t : table) {
            vector<string> row;
            row.push_back(to_string(t.first));
            for (auto f : food) {
                row.push_back(to_string(t.second[f]));
            }
            ret.push_back(row);
        }
        return ret;
    }
};