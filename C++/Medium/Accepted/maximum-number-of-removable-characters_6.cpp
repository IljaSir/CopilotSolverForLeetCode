class Solution {
public:
    int maximumRemovals(string s, string p, vector<int>& removable) {
        
        int left = 0;
        int right = removable.size();
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (check(s, p, removable, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    
    bool check(string s, string p, vector<int>& removable, int k) {
        unordered_set<int> removed;
        for (int i = 0; i < k; ++i) {
            removed.insert(removable[i]);
        }
        int j = 0;
        for (int i = 0; i < s.size(); ++i) {
            if (removed.find(i) == removed.end() && s[i] == p[j]) {
                ++j;
                if (j == p.size()) {
                    return true;
                }
            }
        }
        return false;
    }
};