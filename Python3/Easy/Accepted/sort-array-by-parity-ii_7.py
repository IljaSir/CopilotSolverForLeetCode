class Solution:
    def sortArrayByParityII(self, nums: List[int]) -> List[int]:
        
        odd = []
        even = []
        for i in nums:
            if i % 2 == 0:
                even.append(i)
            else:
                odd.append(i)
        return [x for t in zip(even, odd) for x in t]