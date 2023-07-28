class Solution {
public:
    vector<vector<string>> displayTable(vector<vector<string>>& orders) {
        
        map<int, map<string, int>> foodTable;
        set<string> foodSet;
        set<int> tableSet;
        for (auto& order : orders) {
            foodTable[stoi(order[1])][order[2]]++;
            foodSet.insert(order[2]);
            tableSet.insert(stoi(order[1]));
        }
        
        vector<vector<string>> result;
        vector<string> header;
        header.push_back("Table");
        for (auto& food : foodSet) {
            header.push_back(food);
        }
        result.push_back(header);
        
        for (auto& table : tableSet) {
            vector<string> row;
            row.push_back(to_string(table));
            for (auto& food : foodSet) {
                row.push_back(to_string(foodTable[table][food]));
            }
            result.push_back(row);
        }
        
        return result;
    }
};