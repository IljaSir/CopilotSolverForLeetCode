class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        # O(n) time, O(n) space
        # Create a dictionary of {num: next greater element}
        d = {}
        stack = []
        for num in nums2:
            while stack and stack[-1] < num:
                d[stack.pop()] = num
            stack.append(num)
        # Find next greater element for each num in nums1
        return [d.get(num, -1) for num in nums1]