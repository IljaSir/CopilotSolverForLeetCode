class Solution {
public:
    bool equalFrequency(string word) {
        
        int n = word.size();
        vector<int> cnt(26, 0);
        for (auto c : word) {
            cnt[c - 'a']++;
        }
        int mx = *max_element(cnt.begin(), cnt.end());
        int mn = *min_element(cnt.begin(), cnt.end());
        if (mx == mn) return true;
        if (mn == 1) {
            int cnt1 = count(cnt.begin(), cnt.end(), 1);
            if (cnt1 == 1) return true;
            if (cnt1 > 1) return false;
        }
        if (mx - mn == 1) {
            int cnt1 = count(cnt.begin(), cnt.end(), 1);
            if (cnt1 == 1) return true;
            if (cnt1 > 1) return false;
        }
        return false;
    }
};