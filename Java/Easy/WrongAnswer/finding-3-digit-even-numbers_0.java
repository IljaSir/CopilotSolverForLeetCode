class Solution {
    public int[] findEvenNumbers(int[] digits) {
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {
                    if (i != j && j != k && i != k) {
                        int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                        if (num % 2 == 0) {
                            list.add(num);
                        }
                    }
                }
            }
        }
        return list.stream().sorted().mapToInt(i -> i).toArray();
    }
}