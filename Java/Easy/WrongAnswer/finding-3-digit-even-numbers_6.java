class Solution {
    public int[] findEvenNumbers(int[] digits) {
        
        int[] result = new int[0];
        int[] arr = new int[3];
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {
                    if (i != j && i != k && j != k) {
                        arr[0] = digits[i];
                        arr[1] = digits[j];
                        arr[2] = digits[k];
                        if (arr[0] != 0 && arr[1] != 0 && arr[2] != 0) {
                            int num = arr[0] * 100 + arr[1] * 10 + arr[2];
                            if (num % 2 == 0) {
                                result = Arrays.copyOf(result, result.length + 1);
                                result[result.length - 1] = num;
                            }
                        }
                    }
                }
            }
        }
        Arrays.sort(result);
        return result;
    }
}