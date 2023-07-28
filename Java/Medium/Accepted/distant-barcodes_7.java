class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        
        int[] arr = new int[10001];
        for(int i=0; i<barcodes.length; i++){
            arr[barcodes[i]]++;
        }
        int max = 0;
        int maxInd = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
                maxInd = i;
            }
        }
        int[] result = new int[barcodes.length];
        int index = 0;
        while(arr[maxInd] > 0){
            result[index] = maxInd;
            arr[maxInd]--;
            index += 2;
        }
        for(int i=0; i<arr.length; i++){
            while(arr[i] > 0){
                if(index >= barcodes.length){
                    index = 1;
                }
                result[index] = i;
                arr[i]--;
                index += 2;
            }
        }
        return result;
    }
}