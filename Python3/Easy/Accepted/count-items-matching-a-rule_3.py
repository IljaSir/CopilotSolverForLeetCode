class Solution:
    def countMatches(self, items: List[List[str]], ruleKey: str, ruleValue: str) -> int:
        
        rule_key_index = 0
        if ruleKey == "color":
            rule_key_index = 1
        elif ruleKey == "name":
            rule_key_index = 2
        count = 0
        for item in items:
            if item[rule_key_index] == ruleValue:
                count += 1
        return count