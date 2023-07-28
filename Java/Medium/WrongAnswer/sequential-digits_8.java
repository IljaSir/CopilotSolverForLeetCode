class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        
        List<Integer> result = new ArrayList<>();
        int[] digits = new int[10];
        int i = 0;
        for (; i < 10; i++) {
            digits[i] = i;
        }
        int j = 0;
        int k = 0;
        int n = 0;
        int l = 0;
        for (; j < 10; j++) {
            for (k = j, l = 0; k < 10; k++, l++) {
                n += digits[k] * Math.pow(10, l);
                if (n >= low && n <= high) {
                    result.add(n);
                }
            }
            n = 0;
        }
        Collections.sort(result);
        return result;
    }
}