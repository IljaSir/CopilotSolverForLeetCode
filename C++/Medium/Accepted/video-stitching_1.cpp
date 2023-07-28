class Solution {
public:
    int videoStitching(vector<vector<int>>& clips, int time) {
        
        sort(clips.begin(), clips.end());
        int res = 0, last = 0, cur = 0;
        for (int i = 0; i < clips.size() && last < time; ++i) {
            if (clips[i][0] > last) return -1;
            while (i < clips.size() && clips[i][0] <= last) {
                cur = max(cur, clips[i][1]);
                ++i;
            }
            --i;
            last = cur;
            ++res;
        }
        return last < time ? -1 : res;
    }
};