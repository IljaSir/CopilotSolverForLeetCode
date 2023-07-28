class Solution {
public:
    int componentValue(vector<int>& nums, vector<vector<int>>& edges) {
        
        int size = nums.size();
        vector<int> parents(size, 0);
        for (int i = 0; i < size; ++i) {
            parents[i] = i;
        }
        for (auto& edge : edges) {
            int parent1 = find(parents, edge[0]);
            int parent2 = find(parents, edge[1]);
            if (parent1 != parent2) {
                parents[parent1] = parent2;
            }
        }
        unordered_map<int, int> valueMap;
        for (int i = 0; i < size; ++i) {
            valueMap[find(parents, i)] += nums[i];
        }
        int value = valueMap.begin()->second;
        for (auto it = valueMap.begin(); it != valueMap.end(); ++it) {
            if (it->second != value) {
                return -1;
            }
        }
        return size - valueMap.size();
    }
    int find(vector<int>& parents, int index) {
        if (parents[index] != index) {
            parents[index] = find(parents, parents[index]);
        }
        return parents[index];
    }
};