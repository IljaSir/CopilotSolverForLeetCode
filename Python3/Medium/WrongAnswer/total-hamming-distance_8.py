class Solution:
    def totalHammingDistance(self, nums: List[int]) -> int:
        
        def hammingDistance(a, b):
            c = a ^ b
            cnt = 0
            while c:
                cnt += 1
                c &= c - 1
            return cnt
        return sum(hammingDistance(i, j) for i in nums for j in nums)