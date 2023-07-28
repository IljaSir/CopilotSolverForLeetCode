class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        int count = 0;
        int i = 0;
        while(truckSize > 0 && i < boxTypes.length){
            int[] box = boxTypes[i];
            int numberOfBoxes = box[0];
            int numberOfUnitsPerBox = box[1];
            if(numberOfBoxes <= truckSize){
                count += numberOfBoxes * numberOfUnitsPerBox;
                truckSize -= numberOfBoxes;
            } else {
                count += truckSize * numberOfUnitsPerBox;
                truckSize = 0;
            }
            i++;
        }
        return count;
    }
}