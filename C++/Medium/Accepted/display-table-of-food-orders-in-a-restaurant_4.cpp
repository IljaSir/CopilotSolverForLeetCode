class Solution {
public:
    vector<vector<string>> displayTable(vector<vector<string>>& orders) {
        
        map<int, map<string, int>> table;
        set<string> items;
        for (auto& order : orders) {
            int tableNumber = stoi(order[1]);
            string foodItem = order[2];
            table[tableNumber][foodItem]++;
            items.insert(foodItem);
        }
        vector<vector<string>> ans;
        ans.push_back({"Table"});
        for (auto& item : items) {
            ans[0].push_back(item);
        }
        for (auto& t : table) {
            vector<string> row;
            row.push_back(to_string(t.first));
            for (auto& item : items) {
                row.push_back(to_string(t.second[item]));
            }
            ans.push_back(row);
        }
        return ans;
    }
};