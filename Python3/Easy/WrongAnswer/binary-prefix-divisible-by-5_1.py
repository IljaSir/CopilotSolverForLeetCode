class Solution:
    def prefixesDivBy5(self, nums: List[int]) -> List[bool]:
        
        answer = []
        for i in range(len(nums)):
            if i == 0:
                answer.append(nums[i] % 5 == 0)
            else:
                answer.append((answer[i-1]*2 + nums[i]) % 5 == 0)
        return answer