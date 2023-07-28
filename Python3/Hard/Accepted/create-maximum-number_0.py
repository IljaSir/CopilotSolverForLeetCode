class Solution:
    def maxNumber(self, nums1: List[int], nums2: List[int], k: int) -> List[int]:
        
        def pick_max(nums, k):
            drop = len(nums) - k
            stack = []
            for num in nums:
                while drop and stack and stack[-1] < num:
                    stack.pop()
                    drop -= 1
                stack.append(num)
            return stack[:k]
        
        def merge(A, B):
            return [max(A, B).pop(0) for _ in A+B]
        
        return max(merge(pick_max(nums1, i), pick_max(nums2, k-i)) for i in range(k+1) if i <= len(nums1) and k-i <= len(nums2))