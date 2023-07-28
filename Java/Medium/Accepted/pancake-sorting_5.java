class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        
        List<Integer> result = new ArrayList<>();
        for(int i = arr.length - 1; i > 0; i--) {
            int index = 0;
            for(int j = 0; j <= i; j++) {
                if(arr[j] == i + 1) {
                    index = j;
                    break;
                }
            }
            if(index == i) continue;
            if(index != 0) {
                result.add(index + 1);
                reverse(arr, index);
            }
            result.add(i + 1);
            reverse(arr, i);
        }
        return result;
    }
    
    private void reverse(int[] arr, int index) {
        int i = 0;
        while(i < index) {
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
            i++;
            index--;
        }
    }
}