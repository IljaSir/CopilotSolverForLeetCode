class Solution {
public:
    bool canArrange(vector<int>& arr, int k) {
        
        vector<int> v(k, 0);
        for (auto a: arr) {
            v[((a % k) + k) % k]++;
        }
        if (v[0] % 2 != 0) return false;
        for (int i = 1; i < k; i++) {
            if (v[i] != v[k - i]) return false;
        }
        return true;
    }
};