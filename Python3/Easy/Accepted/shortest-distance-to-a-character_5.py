class Solution:
    def shortestToChar(self, s: str, c: str) -> List[int]:
        
        result = []
        for i in range(len(s)):
            if s[i] == c:
                result.append(0)
            else:
                result.append(1)
        for i in range(len(result)):
            if result[i] == 0:
                continue
            else:
                left = i - 1
                right = i + 1
                while left >= 0:
                    if result[left] == 0:
                        break
                    left -= 1
                while right < len(result):
                    if result[right] == 0:
                        break
                    right += 1
                if left >= 0 and right < len(result):
                    result[i] = min(i - left, right - i)
                elif left >= 0:
                    result[i] = i - left
                elif right < len(result):
                    result[i] = right - i
        return result