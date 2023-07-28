class Solution {
public:
    vector<vector<string>> displayTable(vector<vector<string>>& orders) {
        
        map<int, map<string, int>> m;
        set<string> foods;
        for (auto& order : orders) {
            m[stoi(order[1])][order[2]]++;
            foods.insert(order[2]);
        }
        vector<vector<string>> res;
        vector<string> header;
        header.push_back("Table");
        for (auto& food : foods) {
            header.push_back(food);
        }
        res.push_back(header);
        for (auto& [table, foodMap] : m) {
            vector<string> row;
            row.push_back(to_string(table));
            for (auto& food : foods) {
                row.push_back(to_string(foodMap[food]));
            }
            res.push_back(row);
        }
        return res;
    }
};