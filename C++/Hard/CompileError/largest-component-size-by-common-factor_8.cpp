class Solution {
public:
    int largestComponentSize(vector<int>& nums) {
        
        int n = nums.size();
        int maxNum = *max_element(nums.begin(), nums.end());
        vector<int> fa(maxNum + 1);
        for (int i = 0; i <= maxNum; i++) {
            fa[i] = i;
        }
        for (auto num : nums) {
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    int x = num / i, y = i;
                    int fx = findFa(fa, x), fy = findFa(fa, y);
                    fa[fx] = fy;
                }
            }
        }
        unordered_map<int, int> cnt;
        int ans = 1;
        for (auto num : nums) {
            int f = findFa(fa, num);
            cnt[f]++;
            ans = max(ans, cnt[f]);
        }
        return ans;
    }
};