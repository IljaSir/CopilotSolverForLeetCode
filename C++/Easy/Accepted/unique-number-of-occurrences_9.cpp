class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        
        unordered_map<int, int> occ;
        for (int i = 0; i < arr.size(); i++) {
            occ[arr[i]]++;
        }
        unordered_map<int, int> times;
        for (auto p : occ) {
            times[p.second]++;
        }
        for (auto p : times) {
            if (p.second > 1) return false;
        }
        return true;
    }
};