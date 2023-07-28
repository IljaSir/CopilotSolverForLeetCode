class Solution {
public:
    bool canArrange(vector<int>& arr, int k) {
        
        int n = arr.size();
        unordered_map<int, int> m;
        for (auto a : arr) {
            int r = a % k;
            if (r < 0) r += k;
            m[r]++;
        }
        for (auto [r, cnt] : m) {
            if (r == 0) {
                if (cnt % 2) return false;
            } else {
                if (m[r] != m[k - r]) return false;
            }
        }
        return true;
    }
};