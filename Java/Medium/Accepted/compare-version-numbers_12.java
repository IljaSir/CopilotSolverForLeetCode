class Solution {
    public int compareVersion(String version1, String version2) {
        
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int len1 = nums1.length;
        int len2 = nums2.length;
        int maxLen = Math.max(len1, len2);
        for (int i = 0; i < maxLen; i++) {
            int x = i < len1 ? Integer.parseInt(nums1[i]) : 0;
            int y = i < len2 ? Integer.parseInt(nums2[i]) : 0;
            if (x > y) {
                return 1;
            }
            if (x < y) {
                return -1;
            }
        }
        return 0;
    }
}