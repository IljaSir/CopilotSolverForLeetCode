class Solution {
public:
    int findLucky(vector<int>& arr) {
        
        int n = arr.size();
        if (n == 0) return -1;
        if (n == 1) return arr[0] == 1 ? arr[0] : -1;
        map<int, int> freq;
        for (int i = 0; i < n; i++) {
            freq[arr[i]]++;
        }
        int res = -1;
        for (auto it = freq.begin(); it != freq.end(); it++) {
            if (it->first == it->second) {
                res = it->first;
            }
        }
        return res;
    }
};