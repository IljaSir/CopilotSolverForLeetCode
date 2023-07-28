class Solution:
    def findEvenNumbers(self, digits: List[int]) -> List[int]:
        
        if len(digits) < 3:
            return []
        result = []
        def find_even_numbers(current, remaining):
            if len(current) == 3:
                if int(''.join(current)) % 2 == 0:
                    result.append(int(''.join(current)))
                return
            for i, digit in enumerate(remaining):
                find_even_numbers(current + [digit], remaining[:i] + remaining[i+1:])
        find_even_numbers([], digits)
        return sorted(result)