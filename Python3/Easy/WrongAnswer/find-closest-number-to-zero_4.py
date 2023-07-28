class Solution:
    def findClosestNumber(self, nums: List[int]) -> int:
        
        nums.sort()
        closest = 0
        closest_distance = 0
        for num in nums:
            if closest_distance == 0:
                closest_distance = abs(num)
                closest = num
            elif abs(num) < closest_distance:
                closest_distance = abs(num)
                closest = num
            elif abs(num) == closest_distance:
                closest = num
        return closest