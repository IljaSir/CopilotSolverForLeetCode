class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        
        int carry = 0;
        int i = num.length - 1;
        List<Integer> result = new ArrayList<Integer>();
        while (k > 0 || i >= 0 || carry > 0) {
            int n = k % 10;
            int m = i >= 0 ? num[i] : 0;
            int sum = n + m + carry;
            result.add(0, sum % 10);
            carry = sum / 10;
            k = k / 10;
            i--;
        }
        return result;
    }
}