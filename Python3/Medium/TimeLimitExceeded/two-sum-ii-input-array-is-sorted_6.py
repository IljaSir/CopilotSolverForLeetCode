class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        
        for i, num in enumerate(numbers):
            for j, num2 in enumerate(numbers[i+1:]):
                if num + num2 == target:
                    return [i+1, j+i+2]