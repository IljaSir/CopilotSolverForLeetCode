class Solution {
public:
    int minOperations(vector<int>& target, vector<int>& arr) {
        
        unordered_map<int, int> pos;
        int n = target.size();
        for (int i = 0; i < n; ++i) {
            pos[target[i]] = i;
        }
        vector<int> d;
        for (int val: arr) {
            if (pos.count(val)) {
                int idx = pos[val];
                auto it = lower_bound(d.begin(), d.end(), idx);
                if (it != d.end()) {
                    *it = idx;
                } else {
                    d.push_back(idx);
                }
            }
        }
        return n - d.size();
    }
};