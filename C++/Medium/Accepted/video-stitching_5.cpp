class Solution {
public:
    int videoStitching(vector<vector<int>>& clips, int time) {
        
        sort(clips.begin(), clips.end());
        int n = clips.size(), ans = 0, cur = 0, i = 0;
        while (cur < time) {
            int pre = cur;
            while (i < n && clips[i][0] <= pre) {
                cur = max(cur, clips[i][1]);
                i++;
            }
            if (pre == cur) return -1;
            ans++;
        }
        return ans;
    }
};