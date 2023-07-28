class Solution {
public:
    vector<int> vowelStrings(vector<string>& words, vector<vector<int>>& queries) {
        
        int n = words.size();
        vector<int> ans(queries.size());
        vector<int> a(n);
        vector<int> e(n);
        vector<int> i(n);
        vector<int> o(n);
        vector<int> u(n);
        for(int j = 0; j < n; ++j) {
            for(char c : words[j]) {
                if (c == 'a') a[j]++;
                else if (c == 'e') e[j]++;
                else if (c == 'i') i[j]++;
                else if (c == 'o') o[j]++;
                else if (c == 'u') u[j]++;
            }
        }
        for(int j = 0; j < n; ++j) {
            if (j > 0) {
                a[j] += a[j-1];
                e[j] += e[j-1];
                i[j] += i[j-1];
                o[j] += o[j-1];
                u[j] += u[j-1];
            }
        }
        for(int j = 0; j < queries.size(); ++j) {
            int l = queries[j][0];
            int r = queries[j][1];
            int sum = 0;
            if (l > 0) {
                sum = a[r] - a[l-1] + e[r] - e[l-1] + i[r] - i[l-1] + o[r] - o[l-1] + u[r] - u[l-1];
            } else {
                sum = a[r] + e[r] + i[r] + o[r] + u[r];
            }
            ans[j] = sum;
        }
        return ans;
    }
};