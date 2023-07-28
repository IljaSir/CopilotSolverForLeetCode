class Solution {
public:
    bool canArrange(vector<int>& arr, int k) {
        
        vector<int> mod(k, 0);
        for (int i = 0; i < arr.size(); i++) {
            mod[(arr[i] % k + k) % k]++;
        }
        if (mod[0] % 2) return false;
        for (int i = 1; i <= k / 2; i++) {
            if (mod[i] != mod[k - i]) {
                return false;
            }
        }
        return true;
    }
};