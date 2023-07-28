class Solution:
    def selfDividingNumbers(self, left: int, right: int) -> List[int]:
        
        self_dividing_numbers = []
        for i in range(left, right + 1):
            if self.is_self_dividing_number(i):
                self_dividing_numbers.append(i)
        return self_dividing_numbers