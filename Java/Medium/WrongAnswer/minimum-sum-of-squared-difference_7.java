class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0, n = nums1.length;
        while (i < n && j < n) {
            if (nums1[i] < nums2[j]) {
                map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
                i++;
            } else {
                map.put(nums2[j], map.getOrDefault(nums2[j], 0) - 1);
                j++;
            }
        }
        while (i < n) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
            i++;
        }
        while (j < n) {
            map.put(nums2[j], map.getOrDefault(nums2[j], 0) - 1);
            j++;
        }
        i = 0;
        j = n - 1;
        long res = 0;
        while (i < n) {
            int val = map.get(nums1[i]);
            if (val > 0) {
                res += (long) (nums1[i] - nums2[j]) * (nums1[i] - nums2[j]);
                k2 -= val;
                if (k2 < 0) {
                    break;
                }
                j--;
            } else if (val < 0) {
                res += (long) (nums1[i] - nums2[i]) * (nums1[i] - nums2[i]);
                k1 += val;
                if (k1 < 0) {
                    break;
                }
            }
            i++;
        }
        return res;
    }
}