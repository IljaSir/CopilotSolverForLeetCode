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
        int k = list.size() - 1;
        while (k >= 0 && list.get(k) == 0) {
            k--;
        }
        if (k == -1) {
            return new int[]{0};
        }
        int[] res = new int[k + 1];
        for (int p = 0; p < res.length; p++) {
            res[p] = list.get(k--);
        }
        return res;
    }
}