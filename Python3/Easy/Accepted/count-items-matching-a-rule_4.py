class Solution:
    def countMatches(self, items: List[List[str]], ruleKey: str, ruleValue: str) -> int:
        
        index = {"type": 0, "color": 1, "name": 2}
        return sum(1 for item in items if item[index[ruleKey]] == ruleValue)