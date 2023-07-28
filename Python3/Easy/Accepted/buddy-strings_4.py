class Solution:
    def buddyStrings(self, s: str, goal: str) -> bool:
        
        if len(s) != len(goal):
            return False
        if s == goal:
            return len(set(s)) < len(s)
        first = second = -1
        for i in range(len(s)):
            if s[i] != goal[i]:
                if first == -1:
                    first = i
                elif second == -1:
                    second = i
                else:
                    return False
        return second != -1 and s[first] == goal[second] and s[second] == goal[first]