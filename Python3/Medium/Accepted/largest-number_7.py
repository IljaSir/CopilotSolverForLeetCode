class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        
        s = [str(n) for n in nums]
        s.sort(key = lambda x: x*10, reverse=True)
        return str(int(''.join(s)))