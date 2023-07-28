class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int carry = 0;
        List<Integer> list = new ArrayList<>();
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) {
                sum += arr1[i--];
            }
            if (j >= 0) {
                sum += arr2[j--];
            }
            list.add(sum & 1);
            carry = -(sum >> 1);
        }
        while (list.size() > 1 && list.get(list.size() - 1) == 0) {
            list.remove(list.size() - 1);
        }
        int[] ans = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            ans[k] = list.get(list.size() - 1 - k);
        }
        return ans;
    }
}