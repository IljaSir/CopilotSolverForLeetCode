class Solution {
public:
    int minOperations(vector<int>& target, vector<int>& arr) {
        
        unordered_map<int, int> pos;
        for (int i = 0; i < target.size(); ++i) {
            pos[target[i]] = i;
        }
        vector<int> d;
        for (int val : arr) {
            if (pos.count(val)) {
                int idx = pos[val];
                auto it = lower_bound(d.begin(), d.end(), idx);
                if (it != d.end()) {
                    *it = idx;
                }
                else {
                    d.push_back(idx);
                }
            }
        }
        return target.size() - d.size();
    }
};