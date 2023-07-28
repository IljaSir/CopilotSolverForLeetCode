class Solution {
    public int[] findEvenNumbers(int[] digits) {
        
        int[] result = new int[5];
        int index = 0;
        for(int i = 0; i < digits.length; i++){
            for(int j = 0; j < digits.length; j++){
                if(i != j){
                    for(int k = 0; k < digits.length; k++){
                        if(k != j && k != i){
                            int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                            if(num % 2 == 0){
                                result[index] = num;
                                index++;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}