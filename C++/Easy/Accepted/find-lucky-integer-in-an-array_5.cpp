class Solution {
public:
    int findLucky(vector<int>& arr) {
        
        unordered_map<int, int> m;
        for (auto& i : arr) {
            m[i]++;
        }
        int max = -1;
        for (auto& i : m) {
            if (i.first == i.second && i.first > max) {
                max = i.first;
            }
        }
        return max;
    }
};