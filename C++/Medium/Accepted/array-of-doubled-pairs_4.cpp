class Solution {
public:
    bool canReorderDoubled(vector<int>& arr) {
        
        unordered_map<int, int> counter;
        for (int x : arr) {
            counter[x]++;
        }
        vector<int> keys;
        for (auto& kv : counter) {
            keys.push_back(kv.first);
        }
        sort(keys.begin(), keys.end(), [](int x, int y) {
            return abs(x) < abs(y);
        });
        for (int key : keys) {
            if (counter[key] > counter[2 * key]) {
                return false;
            }
            counter[2 * key] -= counter[key];
        }
        return true;
    }
};