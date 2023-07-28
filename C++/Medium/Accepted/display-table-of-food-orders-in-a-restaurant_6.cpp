class Solution {
public:
    vector<vector<string>> displayTable(vector<vector<string>>& orders) {
        
        map<int, map<string, int>> table;
        set<string> food;
        for (auto& order : orders) {
            int tableNum = atoi(order[1].c_str());
            string foodItem = order[2];
            table[tableNum][foodItem]++;
            food.insert(foodItem);
        }
        vector<string> header;
        header.push_back("Table");
        for (auto& f : food) {
            header.push_back(f);
        }
        vector<vector<string>> result;
        result.push_back(header);
        for (auto& t : table) {
            vector<string> row;
            row.push_back(to_string(t.first));
            for (auto& f : food) {
                row.push_back(to_string(t.second[f]));
            }
            result.push_back(row);
        }
        return result;
    }
};