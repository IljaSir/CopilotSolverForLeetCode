class Solution:
    def fourSumCount(self, nums1: List[int], nums2: List[int], nums3: List[int], nums4: List[int]) -> int:
        
        # 1 <= n <= 200
        # -2^28 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2^28
        # 0 <= i, j, k, l < n
        # nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
        # 2^28 * 4 = 2^30
        # 2^30 / 2^28 = 2^2 = 4
        # 4 * 200 = 800
        # 800 * 200 = 160000
        # 160000 * 200 = 32000000
        # 32000000 * 200 = 6400000000
        # 6400000000 * 200 = 1280000000000
        # 1280000000000 * 200 = 256000000000000
        # 256000000000000 * 200 = 51200000000000000
        # 51200000000000000 * 200 = 10240000000000000000
        # 10240000000000000000 * 200 = 2048000000000000000000
        # 2048000000000000000000 * 200 = 409600000000000000000000
        # 409600000000000000000000 * 200 = 81920000000000000000000000
        # 81920000000000000000000000 * 200 = 16384000000000000000000000000
        # 16384000000000000000000000000 * 200 = 3276800000000000000000000000000
        # 3276800000000000000000000000000 * 200 = 655360000000000000000000000000000
        # 655360000000000000000000000000000 * 200 = 1310720000000