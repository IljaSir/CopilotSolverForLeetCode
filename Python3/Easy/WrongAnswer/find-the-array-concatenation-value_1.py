class Solution:
    def findTheArrayConcVal(self, nums: List[int]) -> int:
        
        def getConcVal(num1, num2):
            return int(str(num1)+str(num2))
        nums.sort()
        concVal = 0
        while len(nums) > 0:
            if len(nums) == 1:
                concVal += nums.pop()
            else:
                concVal += getConcVal(nums.pop(0), nums.pop())
        return concVal