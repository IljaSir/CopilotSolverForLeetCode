class Solution:
    def findEvenNumbers(self, digits: List[int]) -> List[int]:
        
        def get_permutations(digits):
            if len(digits) == 1:
                return [digits]
            permutations = []
            for i in range(len(digits)):
                for permutation in get_permutations(digits[:i] + digits[i+1:]):
                    permutations.append([digits[i]] + permutation)
            return permutations
        permutations = get_permutations(digits)
        result = []
        for permutation in permutations:
            number = 0
            for digit in permutation:
                number = number * 10 + digit
            if number % 2 == 0:
                result.append(number)
        return sorted(result)