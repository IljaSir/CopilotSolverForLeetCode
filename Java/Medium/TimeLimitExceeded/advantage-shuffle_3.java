class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        
        int[] result = new int[nums1.length];
        boolean[] used = new boolean[nums1.length];
        Arrays.sort(nums1);
        for (int i = 0; i < nums2.length; i++) {
            int max = -1;
            for (int j = 0; j < nums1.length; j++) {
                if (!used[j] && nums1[j] > nums2[i]) {
                    max = j;
                    break;
                }
            }
            if (max == -1) {
                for (int j = 0; j < nums1.length; j++) {
                    if (!used[j]) {
                        max = j;
                        break;
                    }
                }
            }
            result[i] = nums1[max];
            used[max] = true;
        }
        return result;
    }
}