class Solution:
    def maximumValue(self, strs: List[str]) -> int:
        
        def get_value(s):
            if s.isdigit():
                return int(s)
            else:
                return len(s)
        return max(map(get_value, strs))