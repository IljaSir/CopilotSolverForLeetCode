class Solution {
public:
    vector<int> sortItems(int n, int m, vector<int>& group, vector<vector<int>>& beforeItems) {
        
        vector<vector<int>> groupGraph(m + n);
        vector<int> groupDegree(m + n);
        for (int i = 0; i < n; ++i) {
            if (group[i] == -1) {
                group[i] = m + i;
            }
        }
        vector<vector<int>> itemGraph(n);
        vector<int> itemDegree(n);
        for (int i = 0; i < n; ++i) {
            int curGroup = group[i];
            for (int item: beforeItems[i]) {
                int beforeGroup = group[item];
                if (beforeGroup == curGroup) {
                    itemGraph[item].push_back(i);
                    ++itemDegree[i];
                }
                else {
                    groupGraph[beforeGroup].push_back(curGroup);
                    ++groupDegree[curGroup];
                }
            }
        }

        vector<int> groupOrder = topSort(groupDegree, groupGraph);
        if (groupOrder.size() == 0) {
            return {};
        }
        vector<int> ans;
        vector<int> itemOrder;
        for (int curGroup: groupOrder) {
            int num = curGroup < m ? 0 : n;
            itemOrder.clear();
            for (int i = 0; i < n; ++i) {
                if (group[i] == curGroup) {
                    itemOrder.push_back(i);
                }
            }
            vector<int> subAns = topSort(itemDegree, itemGraph, itemOrder);
            if (subAns.size() == 0) {
                return {};
            }
            for (int item: subAns) {
                ans.push_back(item);
            }
        }
        return ans;
    }

    vector<int> topSort(vector<int>& degree, vector<vector<int>>& graph, vector<int>& items) {
        queue<int> q;
        for (int item: items) {
            if (degree[item] == 0) {
                q.push(item);
            }
        }
        vector<int> ans;
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            ans.push_back(u);
            for (int v: graph[u]) {
                --degree[v];
                if (degree[v] == 0) {
                    q.push(v);
                }
            }
        }
        if (ans.size() != items.size()) {
            return {};
        }
        return ans;
    }
};