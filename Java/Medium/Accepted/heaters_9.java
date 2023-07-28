class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i = 0;
        int j = 0;
        int max = 0;
        while(i < houses.length){
            if(j < heaters.length - 1 && Math.abs(heaters[j + 1] - houses[i]) <= Math.abs(heaters[j] - houses[i])){
                j++;
            } else {
                max = Math.max(max, Math.abs(heaters[j] - houses[i]));
                i++;
            }
        }
        return max;
    }
}