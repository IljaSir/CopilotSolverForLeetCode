class Solution:
    def secondsToRemoveOccurrences(self, s: str) -> int:
        
        # # O(n) time complexity
        # # O(n) space complexity
        # # 44 ms, 8.33%
        # stack = []
        # for c in s:
        #     if stack and stack[-1] == c:
        #         stack.pop()
        #     else:
        #         stack.append(c)
        # return len(stack) // 2

        # O(n) time complexity
        # O(1) space complexity
        # 36 ms, 8.33%
        count = 0
        for c in s:
            if count and (c == '1' and stack[-1] == '0'):
                count -= 1
                stack.pop()
            else:
                stack.append(c)
                count += 1
        return count // 2