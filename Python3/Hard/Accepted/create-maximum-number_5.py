class Solution:
    def maxNumber(self, nums1: List[int], nums2: List[int], k: int) -> List[int]:
        
        def select_max(nums, k):
            stack = []
            n = len(nums)
            for i, x in enumerate(nums):
                while stack and stack[-1] < x and n - i > k - len(stack):
                    stack.pop()
                if len(stack) < k:
                    stack.append(x)
            return stack
        def merge(a, b):
            return [max(a, b).pop(0) for _ in a+b]
        return max(merge(select_max(nums1, i), select_max(nums2, k-i)) for i in range(k+1) if i <= len(nums1) and k-i <= len(nums2))