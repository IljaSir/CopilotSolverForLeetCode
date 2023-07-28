class Solution {
public:
    string minInteger(string num, int k) {
        
        if (num.size() <= 1) {
            return num;
        }
        int N = num.size();
        int i = 0;
        string res = "";
        while (i < N) {
            int j = i;
            while (j < N && j - i <= k) {
                if (num[j] < num[i]) {
                    i = j;
                }
                j++;
            }
            k -= i - res.size();
            res += num[i];
            num.erase(i, 1);
            i = res.size();
        }
        return res;
    }
};