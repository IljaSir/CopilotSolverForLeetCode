class Solution {
    public int videoStitching(int[][] clips, int time) {
        
        Arrays.sort(clips, (a, b) -> a[0] - b[0]);
        int start = 0;
        int end = 0;
        int count = 0;
        int i = 0;
        while (start < time) {
            while (i < clips.length && clips[i][0] <= start) {
                end = Math.max(end, clips[i][1]);
                i++;
            }
            if (start == end) {
                return -1;
            }
            start = end;
            count++;
        }
        return count;
    }
}