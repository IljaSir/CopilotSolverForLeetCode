class Solution {
public:
    int videoStitching(vector<vector<int>>& clips, int time) {
        
        sort(clips.begin(), clips.end(), [](const vector<int> &a, const vector<int> &b) {
            return a[0] < b[0];
        });
        int n = clips.size();
        if (clips[0][0] != 0) return -1;
        int i = 0;
        int cnt = 0;
        int j = 0;
        while (i < n) {
            int max_end = clips[i][1];
            j = i + 1;
            while (j < n && clips[j][0] <= clips[i][1]) {
                max_end = max(max_end, clips[j][1]);
                j++;
            }
            i = j;
            cnt++;
            if (max_end >= time) return cnt;
        }
        return -1;
    }
};