class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        
        int[] result = new int[nums1.length];
        boolean[] used = new boolean[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < nums1.length; j++) {
                if (nums1[j] > nums2[i] && !used[j]) {
                    if (nums1[j] < min) {
                        min = nums1[j];
                        minIndex = j;
                    }
                }
            }
            if (minIndex != -1) {
                result[i] = min;
                used[minIndex] = true;
            } else {
                for (int j = 0; j < nums1.length; j++) {
                    if (!used[j]) {
                        result[i] = nums1[j];
                        used[j] = true;
                        break;
                    }
                }
            }
        }
        return result;
    }
}