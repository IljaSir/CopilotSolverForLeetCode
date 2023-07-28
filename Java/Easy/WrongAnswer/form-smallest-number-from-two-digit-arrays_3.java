class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        
        int[] arr = new int[nums1.length + nums2.length];
        int i = 0;
        for (int num : nums1) {
            arr[i++] = num;
        }
        for (int num : nums2) {
            arr[i++] = num;
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num);
        }
        return Integer.valueOf(sb.toString());
    }
}