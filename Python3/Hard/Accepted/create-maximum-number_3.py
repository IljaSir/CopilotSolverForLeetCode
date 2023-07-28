class Solution:
    def maxNumber(self, nums1: List[int], nums2: List[int], k: int) -> List[int]:
        
        def get_max(nums, k):
            stack = []
            for i in range(len(nums)):
                while stack and nums[i] > stack[-1] and len(stack) - 1 + len(nums) - i >= k:
                    stack.pop()
                if len(stack) < k:
                    stack.append(nums[i])
            return stack
        def merge(nums1, nums2):
            return [max(nums1, nums2).pop(0) for _ in nums1 + nums2]
        return max(merge(get_max(nums1, i), get_max(nums2, k - i)) for i in range(k + 1) if i <= len(nums1) and k - i <= len(nums2))