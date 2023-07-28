class Solution {
public:
    bool canReorderDoubled(vector<int>& arr) {
        
        unordered_map<int, int> count;
        for (int a : arr) count[a]++;
        vector<int> keys;
        for (auto it : count) keys.push_back(it.first);
        sort(keys.begin(), keys.end(), [](int a, int b) {
            return abs(a) < abs(b);
        });
        for (int x : keys) {
            if (count[x] > count[2 * x]) return false;
            count[2 * x] -= count[x];
        }
        return true;
    }
};