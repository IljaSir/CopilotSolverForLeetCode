class Solution {
    public int[] findEvenNumbers(int[] digits) {
        
        int[] result = new int[0];
        int[] temp = new int[3];
        int count = 0;
        for(int i = 0; i < digits.length; i++) {
            for(int j = 0; j < digits.length; j++) {
                if(i == j) continue;
                for(int k = 0; k < digits.length; k++) {
                    if(i == k || j == k) continue;
                    temp[0] = digits[i];
                    temp[1] = digits[j];
                    temp[2] = digits[k];
                    int sum = temp[0] * 100 + temp[1] * 10 + temp[2];
                    if(sum % 2 == 0) {
                        result = Arrays.copyOf(result, count + 1);
                        result[count] = sum;
                        count++;
                    }
                }
            }
        }
        Arrays.sort(result);
        return result;
    }
}