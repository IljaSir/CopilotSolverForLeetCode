class Solution {
public:
    bool canArrange(vector<int>& arr, int k) {
        
        unordered_map<int, int> m;
        for (int a : arr) {
            int key = ((a % k) + k) % k;
            m[key]++;
        }
        for (auto a : m) {
            int key = a.first;
            int val = a.second;
            if (key == 0) {
                if (val % 2 != 0) {
                    return false;
                }
            } else {
                if (m.find(k - key) == m.end()) {
                    return false;
                }
                if (m[k - key] != val) {
                    return false;
                }
            }
        }
        return true;
    }
};