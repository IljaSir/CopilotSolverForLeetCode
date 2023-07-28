class Solution:
    def sortArrayByParityII(self, nums: List[int]) -> List[int]:
        
        odd = []
        even = []
        for i in nums:
            if i % 2 == 0:
                even.append(i)
            else:
                odd.append(i)
        ans = []
        for i in range(len(nums)):
            if i % 2 == 0:
                ans.append(even.pop())
            else:
                ans.append(odd.pop())
        return ans