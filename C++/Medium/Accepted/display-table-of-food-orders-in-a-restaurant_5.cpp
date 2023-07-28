class Solution {
public:
    vector<vector<string>> displayTable(vector<vector<string>>& orders) {
        
        vector<vector<string>> result;
        map<int, map<string, int>> m;
        set<string> foodItems;
        for (auto& order : orders) {
            int table = stoi(order[1]);
            string food = order[2];
            m[table][food]++;
            foodItems.insert(food);
        }
        vector<string> header;
        header.push_back("Table");
        for (auto& food : foodItems) {
            header.push_back(food);
        }
        result.push_back(header);
        for (auto& table : m) {
            vector<string> row;
            row.push_back(to_string(table.first));
            for (auto& food : foodItems) {
                row.push_back(to_string(table.second[food]));
            }
            result.push_back(row);
        }
        return result;
    }
};