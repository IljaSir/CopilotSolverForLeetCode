class Solution {
    public int videoStitching(int[][] clips, int time) {
        
        // sort clips by start time
        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        // check if there is clip start at 0
        if (clips[0][0] != 0) {
            return -1;
        }
        // maxEnd is the max end time we can reach
        int maxEnd = 0;
        // maxEndNext is the max end time we can reach if we add one more clip
        int maxEndNext = 0;
        // ans is the number of clips we need
        int ans = 0;
        for (int i = 0; i < clips.length; i++) {
            // if the current clip's start time is greater than the max end time we can reach
            // we cannot reach the end
            if (clips[i][0] > maxEnd) {
                return -1;
            }
            // update maxEndNext
            maxEndNext = Math.max(maxEndNext, clips[i][1]);
            // if we have reached the end
            if (maxEnd >= time) {
                return ans;
            }
            // if we have reached the max end time we can reach
            if (i == clips.length - 1 || clips[i + 1][0] > maxEnd) {
                // we need to add one more clip
                ans++;
                // update maxEnd
                maxEnd = maxEndNext;
            }
        }
        // if we have reached the end
        if (maxEnd >= time) {
            return ans;
        }
        return -1;
    }
}