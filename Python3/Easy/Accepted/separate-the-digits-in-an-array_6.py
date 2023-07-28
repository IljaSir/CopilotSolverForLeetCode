class Solution:
    def separateDigits(self, nums: List[int]) -> List[int]:
        
        answer = []
        for n in nums:
            answer.extend([int(x) for x in str(n)])
        return answer