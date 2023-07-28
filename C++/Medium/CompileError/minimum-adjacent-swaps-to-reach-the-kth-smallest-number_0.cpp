class Solution {
public:
    int getMinSwaps(string num, int k) {
        
        string target = num;
        while (k-- > 0) {
            nextPermutation(target);
        }
        int ans = 0;
        for (int i = 0; i < num.size(); ++i) {
            if (num[i] == target[i]) {
                continue;
            }
            for (int j = i + 1; j < num.size(); ++j) {
                if (num[j] == target[i]) {
                    for (int k = j; k > i; --k) {
                        swap(num[k], num[k - 1]);
                        ans++;
                    }
                    break;
                }
            }
        }
        return ans;
    }
};