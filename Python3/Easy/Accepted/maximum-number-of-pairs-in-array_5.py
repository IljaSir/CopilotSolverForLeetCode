class Solution:
    def numberOfPairs(self, nums: List[int]) -> List[int]:
        
        count = 0
        leftover = 0
        for i in range(0, 101):
            if nums.count(i) % 2 == 0:
                count += nums.count(i) // 2
            else:
                count += (nums.count(i) - 1) // 2
                leftover += 1
        return [count, leftover]