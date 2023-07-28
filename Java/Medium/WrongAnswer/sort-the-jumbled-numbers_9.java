class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        
        int[] sorted = new int[nums.length];
        int[] sortedIndex = new int[nums.length];
        int[] sortedValue = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int j = nums[i];
            int k = 0;
            while(j > 0){
                k += mapping[j % 10];
                j /= 10;
                if(j > 0){
                    k *= 10;
                }
            }
            sortedValue[i] = k;
            sortedIndex[i] = i;
        }
        for(int i = 0; i < sorted.length; i++){
            for(int j = i; j < sorted.length; j++){
                if(sortedValue[i] > sortedValue[j]){
                    int temp = sortedValue[i];
                    sortedValue[i] = sortedValue[j];
                    sortedValue[j] = temp;
                    
                    temp = sortedIndex[i];
                    sortedIndex[i] = sortedIndex[j];
                    sortedIndex[j] = temp;
                }
            }
        }
        for(int i = 0; i < sorted.length; i++){
            sorted[i] = nums[sortedIndex[i]];
        }
        return sorted;
    }
}