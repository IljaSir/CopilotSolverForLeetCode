class Solution:
    def separateDigits(self, nums: List[int]) -> List[int]:
        
        answer = []
        for n in nums:
            for d in str(n):
                answer.append(int(d))
        return answer