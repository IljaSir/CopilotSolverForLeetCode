class Solution {
public:
    vector<vector<string>> displayTable(vector<vector<string>>& orders) {
        
        // map<Table, map<Food, Count>>
        map<int, map<string, int>> table;
        set<string> food;
        for (auto& order : orders) {
            int tableNumber = stoi(order[1]);
            string foodItem = order[2];
            table[tableNumber][foodItem]++;
            food.insert(foodItem);
        }
        
        vector<vector<string>> tableList;
        vector<string> header;
        header.push_back("Table");
        for (auto& foodItem : food) {
            header.push_back(foodItem);
        }
        tableList.push_back(header);
        
        for (auto& t : table) {
            vector<string> row;
            row.push_back(to_string(t.first));
            for (auto& foodItem : food) {
                row.push_back(to_string(t.second[foodItem]));
            }
            tableList.push_back(row);
        }
        
        return tableList;
    }
};