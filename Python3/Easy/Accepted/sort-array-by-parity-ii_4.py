class Solution:
    def sortArrayByParityII(self, nums: List[int]) -> List[int]:
        
        odd = []
        even = []
        for num in nums:
            if num % 2 == 0:
                even.append(num)
            else:
                odd.append(num)
        output = []
        for i in range(len(nums)):
            if i % 2 == 0:
                output.append(even.pop())
            else:
                output.append(odd.pop())
        return output