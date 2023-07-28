class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        
        List<Integer> ans = new ArrayList<Integer>();
        int[] digits = {1,2,3,4,5,6,7,8,9};
        for (int i = 0; i < digits.length; i++) {
            int n = digits[i];
            for (int j = i+1; j < digits.length; j++) {
                n = n * 10 + digits[j];
                if (n >= low && n <= high) {
                    ans.add(n);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}