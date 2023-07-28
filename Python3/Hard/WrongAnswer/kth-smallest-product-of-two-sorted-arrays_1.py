class Solution:
    def kthSmallestProduct(self, nums1: List[int], nums2: List[int], k: int) -> int:
        
        def count_smaller_than_or_equal_to(nums1, nums2, target):
            i, j, count = 0, len(nums2)-1, 0
            while i < len(nums1) and j >= 0:
                if nums1[i] * nums2[j] <= target:
                    count += j+1
                    i += 1
                else:
                    j -= 1
            return count

        left, right = nums1[0] * nums2[0], nums1[-1] * nums2[-1]
        while left < right:
            mid = (left + right) // 2
            if count_smaller_than_or_equal_to(nums1, nums2, mid) >= k:
                right = mid
            else:
                left = mid + 1
        return left