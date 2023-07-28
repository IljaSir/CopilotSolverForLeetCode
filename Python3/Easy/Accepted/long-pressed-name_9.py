class Solution:
    def isLongPressedName(self, name: str, typed: str) -> bool:
        
        name = list(name)
        typed = list(typed)
        typed_count = 0
        name_count = 0
        while typed_count < len(typed) and name_count < len(name):
            if typed[typed_count] == name[name_count]:
                typed_count += 1
                name_count += 1
            elif typed_count > 0 and typed[typed_count] == typed[typed_count - 1]:
                typed_count += 1
            else:
                return False
        if name_count < len(name):
            return False
        while typed_count < len(typed):
            if typed[typed_count] != typed[typed_count - 1]:
                return False
            typed_count += 1
        return True