class Solution {
public:
    int largestInteger(int num) {
        
        string s = to_string(num);
        int n = s.size();
        vector<int> odd, even;
        for (int i = 0; i < n; ++i) {
            if ((s[i] - '0') % 2 == 0) {
                even.push_back(i);
            } else {
                odd.push_back(i);
            }
        }
        int i = 0, j = 0;
        while (i < even.size() && j < odd.size()) {
            if (s[even[i]] < s[odd[j]]) {
                swap(s[even[i]], s[odd[j]]);
                i++;
                j++;
            } else {
                j++;
            }
        }
        return stoi(s);
    }
};