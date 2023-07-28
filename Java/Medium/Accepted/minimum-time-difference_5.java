class Solution {
    public int findMinDifference(List<String> timePoints) {
        
        int n = timePoints.size();
        int[] minutes = new int[n];
        for(int i = 0; i < n; i++){
            String[] time = timePoints.get(i).split(":");
            minutes[i] = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        }
        Arrays.sort(minutes);
        int ans = minutes[0] + 1440 - minutes[n - 1];
        for(int i = 1; i < n; i++){
            ans = Math.min(ans, minutes[i] - minutes[i - 1]);
        }
        return ans;
    }
}