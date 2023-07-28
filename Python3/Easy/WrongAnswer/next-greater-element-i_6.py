class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        stack = []
        next_greater = {}
        for i in range(len(nums2)):
            while stack and nums2[i] > nums2[stack[-1]]:
                next_greater[stack.pop()] = nums2[i]
            stack.append(i)
        return [next_greater.get(i, -1) for i in range(len(nums1))]