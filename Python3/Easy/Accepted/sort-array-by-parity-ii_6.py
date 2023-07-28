class Solution:
    def sortArrayByParityII(self, nums: List[int]) -> List[int]:
        
        even, odd = [], []
        for num in nums:
            if num % 2 == 0:
                even.append(num)
            else:
                odd.append(num)
        return [even[i // 2] if i % 2 == 0 else odd[i // 2] for i in range(len(nums))]