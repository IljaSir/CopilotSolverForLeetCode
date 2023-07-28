class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        
        int[] a = new int[10];
        int[] b = new int[10];
        for (int i = 0; i < nums1.length; i++) {
            a[nums1[i]]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            b[nums2[i]]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int count = Math.min(a[i], b[i]);
            for (int j = 0; j < count; j++) {
                sb.append(i);
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < a[i] - b[i]; j++) {
                sb.append(i);
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < b[i] - a[i]; j++) {
                sb.append(i);
            }
        }
        return Integer.parseInt(sb.toString());
    }
}