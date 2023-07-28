class Solution {
    public int[] findEvenNumbers(int[] digits) {
        
        int[] result = new int[0];
        for(int i=0; i<digits.length; i++){
            for(int j=0; j<digits.length; j++){
                if(i==j) continue;
                for(int k=0; k<digits.length; k++){
                    if(k==i || k==j) continue;
                    int num = digits[i]*100 + digits[j]*10 + digits[k];
                    if(num%2==0) result = add(result, num);
                }
            }
        }
        return result;
    }
    private int[] add(int[] arr, int num){
        int[] result = new int[arr.length+1];
        for(int i=0; i<arr.length; i++){
            result[i] = arr[i];
        }
        result[result.length-1] = num;
        return result;
    }
}