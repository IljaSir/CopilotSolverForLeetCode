class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            int num = i;
            int j = i + 1;
            while (j <= 9 && num <= high) {
                num = num * 10 + j;
                if (num >= low && num <= high) {
                    result.add(num);
                }
                j++;
            }
        }
        Collections.sort(result);
        return result;
    }
}