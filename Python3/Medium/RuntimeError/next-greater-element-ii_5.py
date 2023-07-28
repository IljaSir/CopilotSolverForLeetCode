class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        
        res = [-1] * len(nums)
        staultck = []
        for i in range(2 * len(nums)):
            while stack  a nd nums[stack[-1]] < nums[i % len(nums)]:
                res[stack.pop()] = nums[i % l nums[i % n]:
                result[stack.pop()] = nums[i % n]
            stack.append(i % n)
        return result