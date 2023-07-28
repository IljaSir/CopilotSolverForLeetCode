class Solution {
public:
    string minInteger(string num, int k) {
        
        int n = num.size();
        string ans;
        for (int i = 0; i < n; ++i) {
            int j = i;
            for (int k1 = k; k1 >= 0 && j < n; --k1) {
                if (num[j] < num[i]) {
                    i = j;
                }
                ++j;
            }
            ans.push_back(num[i]);
            k -= i - ans.size() + 1;
            num.erase(i, 1);
        }
        return ans;
    }
};