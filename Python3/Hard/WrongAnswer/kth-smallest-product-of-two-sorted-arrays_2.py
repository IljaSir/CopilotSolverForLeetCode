class Solution:
    def kthSmallestProduct(self, nums1: List[int], nums2: List[int], k: int) -> int:
        
        # binary search
        def count_smaller(x):
            # count the number of elements in nums1 * nums2 smaller than x
            # two pointer
            j = len(nums2) - 1
            cnt = 0
            for i in range(len(nums1)):
                while j >= 0 and nums1[i] * nums2[j] >= x:
                    j -= 1
                cnt += j + 1
            return cnt
        
        # find the smallest x s.t. count_smaller(x) >= k
        left, right = 0, 10**10
        while left < right:
            mid = (left + right) // 2
            if count_smaller(mid) >= k:
                right = mid
            else:
                left = mid + 1
        return left