class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int carry = 0;
        List<Integer> res = new ArrayList<>();
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) {
                sum += arr1[i--];
            }
            if (j >= 0) {
                sum += arr2[j--];
            }
            res.add(sum % 2);
            carry = -(sum / 2);
        }
        Collections.reverse(res);
        while (res.size() > 1 && res.get(0) == 0) {
            res.remove(0);
        }
        int[] result = new int[res.size()];
        for (int k = 0; k < res.size(); k++) {
            result[k] = res.get(k);
        }
        return result;
    }
}