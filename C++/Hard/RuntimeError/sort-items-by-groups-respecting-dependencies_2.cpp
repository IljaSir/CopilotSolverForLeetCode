class Solution {
public:
    vector<int> sortItems(int n, int m, vector<int>& group, vector<vector<int>>& beforeItems) {
        
        vector<vector<int>> groupItem(n);
        for (int i = 0; i < n; ++i) {
            if (group[i] == -1) {
                group[i] = m++;
            }
            groupItem[group[i]].push_back(i);
        }
        vector<vector<int>> groupGraph(m);
        vector<int> groupDegree(m);
        vector<vector<int>> itemGraph(n);
        vector<int> itemDegree(n);
        vector<int> id(m);
        iota(id.begin(), id.end(), 0);
        for (int i = 0; i < n; ++i) {
            int curGroup = group[i];
            for (int item : beforeItems[i]) {
                int beforeGroup = group[item];
                if (curGroup == beforeGroup) {
                    itemGraph[item].push_back(i);
                    ++itemDegree[i];
                }
                else {
                    groupGraph[beforeGroup].push_back(curGroup);
                    ++groupDegree[curGroup];
                }
            }
        }
        vector<int> groupOrder;
        if (!topSort(id, groupDegree, groupGraph, groupOrder)) {
            return {};
        }
        vector<int> ans;
        for (int &curGroup : groupOrder) {
            int size = groupItem[curGroup].size();
            if (size == 0) {
                continue;
            }
            vector<int> res;
            if (!topSort(groupItem[curGroup], itemDegree, itemGraph, res)) {
                return {};
            }
            for (int &item : res) {
                ans.push_back(item);
            }
        }
        return ans;
    }
    bool topSort(vector<int> &id, vector<int> &degree, vector<vector<int>> &graph, vector<int> &order) {
        queue<int> q;
        for (int &i : id) {
            if (degree[i] == 0) {
                q.push(i);
            }
        }
        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            order.push_back(cur);
            for (int &next : graph[cur]) {
                if (--degree[next] == 0) {
                    q.push(next);
                }
            }
        }
        return order.size() == id.size();
    }
};