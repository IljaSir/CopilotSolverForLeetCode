class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        
        stack = []
        for a in asteroids:
            if a > 0:
                stack.append(a)
            else:
                while stack and stack[-1] > 0:
                    if stack[-1] < -a:
                        stack.pop()
                        continue
                    elif stack[-1] == -a:
                        stack.pop()
                    break
                else:
                    stack.append(a)
        return stack