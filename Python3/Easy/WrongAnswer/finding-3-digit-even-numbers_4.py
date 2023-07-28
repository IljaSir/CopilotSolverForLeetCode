class Solution:
    def findEvenNumbers(self, digits: List[int]) -> List[int]:
        
        # 1. Find all even numbers
        # 2. Find all unique numbers
        # 3. Sort the list
        # 4. Return the list
        return sorted(set([int(''.join(i)) for i in itertools.permutations([str(i) for i in digits], 3) if int(''.join(i)) % 2 == 0]))