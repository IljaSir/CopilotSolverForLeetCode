class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        stack = []
        d = {}
        for i in nums2:
            while stack and i > stack[-1]:
                d[stack.pop()] = i
            stack.append(i)
        return [d.get(i, -1) for i in nums1]