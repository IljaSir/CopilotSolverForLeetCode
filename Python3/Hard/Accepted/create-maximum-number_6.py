class Solution:
    def maxNumber(self, nums1: List[int], nums2: List[int], k: int) -> List[int]:
        
        def get_max_subsequence(nums, k):
            stack = []
            n = len(nums)
            for i in range(n):
                while stack and stack[-1] < nums[i] and n - i + len(stack) > k:
                    stack.pop()
                if len(stack) < k:
                    stack.append(nums[i])
            return stack

        def merge(nums1, nums2):
            res = []
            while nums1 or nums2:
                if nums1 > nums2:
                    res.append(nums1.pop(0))
                else:
                    res.append(nums2.pop(0))
            return res

        res = []
        for i in range(k + 1):
            if i <= len(nums1) and k - i <= len(nums2):
                res = max(res, merge(get_max_subsequence(nums1, i), get_max_subsequence(nums2, k - i)))
        return res