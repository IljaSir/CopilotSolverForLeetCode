class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        
        int n = num.length;
        int i = n - 1;
        int carry = 0;
        List<Integer> ans = new ArrayList<>();
        while (i >= 0 || k > 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += num[i];
                i--;
            }
            if (k > 0) {
                sum += k % 10;
                k /= 10;
            }
            carry = sum / 10;
            sum = sum % 10;
            ans.add(sum);
        }
        Collections.reverse(ans);
        return ans;
    }
}