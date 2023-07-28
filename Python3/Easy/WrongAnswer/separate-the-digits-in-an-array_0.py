class Solution:
    def separateDigits(self, nums: List[int]) -> List[int]:
        
        result = []
        for num in nums:
            while num > 0:
                result.append(num % 10)
                num //= 10
        result.reverse()
        return result