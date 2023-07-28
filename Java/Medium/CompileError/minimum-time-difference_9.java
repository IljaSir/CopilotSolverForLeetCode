class Solution {
    public int findMinDifference(List<String> timePoints) {
        
        int min = 24*60;
        int[] mins = new int[timePoints.size()];
        for(int i=0;i<timePoints.size();i++){
            mins[i] = convert(timePoints.get(i));
        }
        Arrays.sort(mins);
        for(int i=0;i<mins.length-1;i++){
            min = Math.min(min, mins[i+1]-mins[i]);
        }
        min = Math.min(min, mins[0]+24*60-mins[mins.length-1]);
        return min;
    }
}