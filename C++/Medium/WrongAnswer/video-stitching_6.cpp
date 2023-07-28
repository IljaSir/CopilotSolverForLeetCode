class Solution {
public:
    int videoStitching(vector<vector<int>>& clips, int time) {
        
        sort(clips.begin(), clips.end());
        int n = clips.size();
        int ans = 0;
        int i = 0;
        int j = 0;
        int max = 0;
        while (i < n && j < n) {
            while (i < n && clips[i][0] <= j) {
                if (clips[i][1] > max) {
                    max = clips[i][1];
                }
                i++;
            }
            if (max <= j) {
                return -1;
            }
            j = max;
            ans++;
            if (j >= time) {
                return ans;
            }
        }
        return -1;
    }
};