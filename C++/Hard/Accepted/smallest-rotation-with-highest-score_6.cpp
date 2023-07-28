class Solution {
public:
    int bestRotation(vector<int>& nums) {
        
        int N = nums.size();
        vector<int> change(N, 0);
        for (int i = 0; i < N; ++i) {
            int left = (i - nums[i] + 1 + N) % N, right = (i + 1) % N;
            change[left]--;
            change[right]++;
            if (left > right) {
                change[0]--;
            }
        }
        int best = -N, ans = 0, now = 0;
        for (int i = 0; i < N; ++i) {
            now += change[i];
            if (now > best) {
                best = now;
                ans = i;
            }
        }
        return ans;
    }
};