class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int carry = 0;
        List<Integer> ans = new ArrayList<>();
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) {
                carry += arr1[i--];
            }
            if (j >= 0) {
                carry += arr2[j--];
            }
            ans.add(carry & 1);
            carry = -(carry >> 1);
        }
        while (ans.size() > 1 && ans.get(ans.size() - 1) == 0) {
            ans.remove(ans.size() - 1);
        }
        Collections.reverse(ans);
        int[] res = new int[ans.size()];
        for (int k = 0; k < ans.size(); k++) {
            res[k] = ans.get(k);
        }
        return res;
    }
}