class Solution:
    def platesBetweenCandles(self, s: str, queries: List[List[int]]) -> List[int]:
        
        result = []
        for query in queries:
            left = query[0]
            right = query[1]
            num_plates = 0
            num_plates += s[left:right + 1].count('*')
            if left > 0 and s[left - 1] == '*':
                num_plates -= 1
            if right < len(s) - 1 and s[right + 1] == '*':
                num_plates -= 1
            result.append(num_plates)
        return result