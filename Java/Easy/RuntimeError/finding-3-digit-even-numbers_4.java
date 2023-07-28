class Solution {
    public int[] findEvenNumbers(int[] digits) {
        
        int[] result = new int[10];
        int resultIndex = 0;
        for(int i = 0; i < digits.length; i++) {
            for(int j = 0; j < digits.length; j++) {
                for(int k = 0; k < digits.length; k++) {
                    if(i != j && i != k && j != k) {
                        int number = digits[i] * 100 + digits[j] * 10 + digits[k];
                        if(number % 2 == 0) {
                            result[resultIndex] = number;
                            resultIndex++;
                        }
                    }
                }
            }
        }
        int[] finalResult = new int[resultIndex];
        for(int i = 0; i < resultIndex; i++) {
            finalResult[i] = result[i];
        }
        return finalResult;
    }
}