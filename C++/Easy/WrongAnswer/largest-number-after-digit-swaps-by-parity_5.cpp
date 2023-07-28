class Solution {
public:
    int largestInteger(int num) {
        
        string s = to_string(num);
        int n = s.size();
        vector<int> even, odd;
        for (char c : s) {
            if ((c - '0') % 2 == 0) even.push_back(c - '0');
            else odd.push_back(c - '0');
        }
        sort(even.begin(), even.end());
        sort(odd.begin(), odd.end());
        int i = 0, j = 0;
        string res;
        while (i < even.size() && j < odd.size()) {
            if (even[i] > odd[j]) {
                res += (even[i++] + '0');
            } else {
                res += (odd[j++] + '0');
            }
        }
        while (i < even.size()) res += (even[i++] + '0');
        while (j < odd.size()) res += (odd[j++] + '0');
        return stoi(res);
    }
};