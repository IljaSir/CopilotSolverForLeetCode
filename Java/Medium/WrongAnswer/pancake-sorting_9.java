class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            int max = arr[i];
            int maxIndex = i;
            for(int j = i; j < arr.length; j++){
                if(arr[j] > max){
                    max = arr[j];
                    maxIndex = j;
                }
            }
            if(maxIndex != i){
                reverse(arr, maxIndex);
                ans.add(maxIndex+1);
                reverse(arr, i);
                ans.add(i+1);
            }
        }
        return ans;
    }
    
    public void reverse(int[] arr, int index){
        int i = 0;
        int j = index;
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}