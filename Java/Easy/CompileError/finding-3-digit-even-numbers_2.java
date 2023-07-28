class Solution {
    public int[] findEvenNumbers(int[] digits) {
        
        int[] result = new int[0];
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {
                    if (i == j || i == k || j == k) {
                        continue;
                    }
                    int number = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (number % 2 == 0) {
                        result = append(result, number);
                    }
                }
            }
        }
        return result;
    }
    
    public int[] append(int[] a, int b) {
        int[] result = new int[a.length + 1];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i];
        }
        result[a.length] = b;
        return result;
    }
}
    }
}