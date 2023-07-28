class Solution {
public:
    long long appealSum(string s) {
        
        long long result = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int count[26] = {0};
            int k = 0;
            for (int j = i; j < n; j++) {
                int index = s[j] - 'a';
                if (count[index] == 0) {
                    count[index] = 1;
                    k++;
                }
                result += k;
            }
        }
        return result;
    }
};