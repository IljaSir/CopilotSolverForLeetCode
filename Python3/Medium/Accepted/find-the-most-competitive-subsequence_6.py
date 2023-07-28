class Solution:
    def mostCompetitive(self, nums: List[int], k: int) -> List[int]:
        
        # create a stack
        stack = []
        # iterate through nums
        for i, num in enumerate(nums):
            # while there are elements in the stack and the last element is greater than the current element
            while stack and stack[-1] > num and len(stack) - 1 + len(nums) - i >= k:
                # pop the stack
                stack.pop()
            # if the length of the stack is less than k
            if len(stack) < k:
                # append the element to the stack
                stack.append(num)
        # return the stack
        return stack