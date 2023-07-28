class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        
        List<Integer> result = new ArrayList<>();
        int carry = 0;
        for (int i = num.length - 1; i >= 0; i--) {
            int sum = num[i] + k % 10 + carry;
            result.add(sum % 10);
            carry = sum / 10;
            k /= 10;
        }
        for (; k > 0 || carry > 0; k /= 10) {
            int sum = k % 10 + carry;
            result.add(sum % 10);
            carry = sum / 10;
        }
        Collections.reverse(result);
        return result;
    }
}