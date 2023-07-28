class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        
        for i in range(len(numbers)):
            if target-numbers[i] in numbers[i+1:]:
                return [i+1,i+2+numbers[i+1:].index(target-numbers[i])]