class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        
        for i in range(len(numbers)):
            if target - numbers[i] in numbers:
                j = numbers.index(target - numbers[i])
                if i != j:
                    return [i+1, j+1]