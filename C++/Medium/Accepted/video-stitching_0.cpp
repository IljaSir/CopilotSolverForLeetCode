class Solution {
public:
    int videoStitching(vector<vector<int>>& clips, int time) {
        
        sort(clips.begin(), clips.end(), [](vector<int> a, vector<int> b) {
            if (a[0] == b[0]) return a[1] > b[1];
            return a[0] < b[0];
        });
        int res = 0, end = 0, pre = 0;
        for (auto clip : clips) {
            if (clip[0] > end) return -1;
            if (clip[0] > pre) {
                res++;
                pre = end;
            }
            end = max(end, clip[1]);
            if (end >= time) return res + 1;
        }
        return -1;
    }
};