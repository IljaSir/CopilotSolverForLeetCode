class Solution {
public:
    int countLargestGroup(int n) {
        
        vector<int> count(37, 0);
        for (int i = 1; i <= n; i++) {
            int t = i;
            int sum = 0;
            while (t > 0) {
                sum += t % 10;
                t /= 10;
            }
            count[sum]++;
        }
        int max = 0;
        for (int i = 0; i < count.size(); i++) {
            if (count[i] > max) {
                max = count[i];
            }
        }
        int ans = 0;
        for (int i = 0; i < count.size(); i++) {
            if (count[i] == max) {
                ans++;
            }
        }
        return ans;
    }
};