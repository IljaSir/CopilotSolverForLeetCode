class Solution:
    def countMatches(self, items: List[List[str]], ruleKey: str, ruleValue: str) -> int:
        
        ruleIndex = 0
        if ruleKey == "color":
            ruleIndex = 1
        elif ruleKey == "name":
            ruleIndex = 2
        return sum([1 for item in items if item[ruleIndex] == ruleValue])