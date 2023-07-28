class Solution {
public:
    long long appealSum(string s) {
        
        long long sum = 0;
        for (int i = 0; i < s.size(); i++) {
            int j = i;
            int count = 0;
            vector<bool> seen(26, false);
            while (j < s.size()) {
                if (!seen[s[j] - 'a']) {
                    count++;
                    seen[s[j] - 'a'] = true;
                }
                sum += count;
                j++;
            }
        }
        return sum;
    }
};