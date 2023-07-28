class Solution {
public:
    bool canArrange(vector<int>& arr, int k) {
        
        unordered_map<int, int> m;
        for (int i = 0; i < arr.size(); i++) {
            m[(arr[i] % k + k) % k]++;
        }
        for (int i = 0; i < arr.size(); i++) {
            int x = (arr[i] % k + k) % k;
            if (x == 0) {
                if (m[x] % 2 != 0) return false;
            } else {
                if (m[x] != m[k - x]) return false;
            }
        }
        return true;
    }
};