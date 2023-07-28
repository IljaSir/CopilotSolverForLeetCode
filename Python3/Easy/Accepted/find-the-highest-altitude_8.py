class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        
        height = 0
        highest = 0
        for i in gain:
            height += i
            highest = max(height, highest)
        return highest