class Solution:
    def maxNumber(self, nums1: List[int], nums2: List[int], k: int) -> List[int]:
        
        def maxSubArray(nums, k):
            stack = []
            for i, num in enumerate(nums):
                while stack and stack[-1] < num and len(stack) + len(nums) - i > k:
                    stack.pop()
                if len(stack) < k:
                    stack.append(num)
            return stack
        
        def merge(nums1, nums2):
            return [max(nums1, nums2).pop(0) for _ in nums1 + nums2]
        
        return max(merge(maxSubArray(nums1, i), maxSubArray(nums2, k-i)) for i in range(k+1) if i <= len(nums1) and k-i <= len(nums2))