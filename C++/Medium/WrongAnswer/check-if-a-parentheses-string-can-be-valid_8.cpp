class Solution {
public:
    bool canBeValid(string s, string locked) {
        
        int n = s.size();
        int cnt = 0;
        vector<int> cnts(n);
        for (int i = 0; i < n; i++) {
            if (s[i] == '(') {
                cnt++;
            } else {
                cnt--;
            }
            cnts[i] = cnt;
        }
        if (cnt != 0) return false;
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '(') {
                left++;
            } else {
                right++;
            }
            if (locked[i] == '1') {
                if (left < right) return false;
            } else {
                if (cnts[i] < 0) return false;
            }
        }
        return true;
    }
};