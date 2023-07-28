class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 1; i < 9; i++) {
            int num = i;
            while (num <= high) {
                if (num >= low) {
                    res.add(num);
                }
                num = num * 10 + ((num % 10) + 1);
            }
        }
        Collections.sort(res);
        return res;
    }
}