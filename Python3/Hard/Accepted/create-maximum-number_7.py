class Solution:
    def maxNumber(self, nums1: List[int], nums2: List[int], k: int) -> List[int]:
        
        def max_seq(nums, k):
            stack = []
            n = len(nums)
            for i in range(n):
                while stack and stack[-1] < nums[i] and len(stack) + n - i > k:
                    stack.pop()
                if len(stack) < k:
                    stack.append(nums[i])
            return stack
        def merge(nums1, nums2):
            return [max(nums1, nums2).pop(0) for _ in nums1 + nums2]
        return max(merge(max_seq(nums1, i), max_seq(nums2, k-i)) for i in range(k+1) if i <= len(nums1) and k-i <= len(nums2))