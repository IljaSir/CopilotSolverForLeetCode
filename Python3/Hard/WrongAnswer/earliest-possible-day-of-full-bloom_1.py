class Solution:
    def earliestFullBloom(self, plantTime: List[int], growTime: List[int]) -> int:
        
        n = len(plantTime)
        plantTime.sort()
        growTime.sort()
        ans = 0
        for i in range(n):
            ans = max(ans, plantTime[i] + growTime[n - i - 1])
        return ans + 1