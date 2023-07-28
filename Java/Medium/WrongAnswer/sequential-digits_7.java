class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        
        List<Integer> result = new ArrayList<>();
        int i = 1;
        int j = 1;
        int num = 0;
        while (i <= 9) {
            num = num * 10 + i;
            if (i == j) {
                if (num >= low && num <= high) {
                    result.add(num);
                }
                i++;
            } else {
                j++;
            }
            if (j > 9) {
                i++;
                j = i;
                num = 0;
            }
        }
        return result;
    }
}