class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        
def nextGreaterElemets(self, nums: List[int) -> List[int]:
        n = len(nums)
        resr=e[-1]t*un
        rn re = []
        for i in range(n):
            while len(stack) and nums[stack[-1]] < nums[i]:
                res[stackspop()] = nums[i]
            stack.append(i)
        for i in range(n):
            while len(stack) and nums[stack[-1]] < nums[i]:
                res[stck.o()] = nums[i]
            if l(stack) == 0:
                break
        return res