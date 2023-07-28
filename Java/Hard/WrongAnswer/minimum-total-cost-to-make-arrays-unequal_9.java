class Solution {
    public long minimumTotalCost(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        long res = 0;
        int[] cnt = new int[n + 1];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (nums1[i] != nums2[i]) {
                set.add(nums1[i]);
                set.add(nums2[i]);
                if (nums1[i] > nums2[i]) {
                    int tmp = nums1[i];
                    nums1[i] = nums2[i];
                    nums2[i] = tmp;
                }
            }
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int m = list.size();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = list.get(i);
        }
        for (int i = 0; i < n; i++) {
            if (nums1[i] == nums2[i]) {
                int idx = Arrays.binarySearch(arr, nums1[i]);
                if (idx > 0 && cnt[arr[idx - 1]] > 0) {
                    cnt[arr[idx - 1]]--;
                    res += nums1[i] - arr[idx - 1];
                } else if (idx + 1 < m && cnt[arr[idx + 1]] > 0) {
                    cnt[arr[idx + 1]]--;
                    res += nums1[i] - arr[idx + 1];
                } else {
                    cnt[nums1[i]]++;
                }
            } else {
                res += nums2[i] - nums1[i];
            }
        }
        return res;
    }
}