class Solution:
    def prefixesDivBy5(self, nums: List[int]) -> List[bool]:
        
        ans = []
        curr = 0
        for i in range(len(nums)):
            curr = curr * 2 + nums[i]
            ans.append(curr % 5 == 0)
        return ans