class Solution {
    public int[] findEvenNumbers(int[] digits) {
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {
                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (i != j && i != k && j != k && num % 2 == 0) {
                        list.add(num);
                    }
                }
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        Arrays.sort(result);
        return result;
    }
}