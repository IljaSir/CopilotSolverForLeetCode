class Solution {
public:
    vector<int> splitIntoFibonacci(string num) {
        
        vector<int> result;
        if (num.size() < 3) return result;
        int n = num.size();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                string str1 = num.substr(0, i);
                string str2 = num.substr(i, j - i);
                if (str1.size() > 1 && str1[0] == '0') continue;
                if (str2.size() > 1 && str2[0] == '0') continue;
                long long n1 = stoll(str1);
                long long n2 = stoll(str2);
                if (n1 > INT_MAX || n2 > INT_MAX) break;
                result.push_back(n1);
                result.push_back(n2);
                if (dfs(num, j, n1, n2, result)) return result;
                result.clear();
            }
        }
        return result;
    }
};