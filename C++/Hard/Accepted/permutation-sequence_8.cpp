class Solution {
public:
    string getPermutation(int n, int k) {
        
        string res;
        vector<int> nums(n+1, 1);
        for (int i = 1; i <= n; i++) {
            nums[i] = nums[i-1] * i;
        }
        vector<int> visited(n+1, 0);
        for (int i = 1; i <= n; i++) {
            int index = (k-1) / nums[n-i] + 1;
            k = k - (index-1) * nums[n-i];
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (visited[j] == 0) {
                    cnt++;
                    if (cnt == index) {
                        res += to_string(j);
                        visited[j] = 1;
                        break;
                    }
                }
            }
        }
        return res;
    }
};