class Solution:
    def countMatches(self, items: List[List[str]], ruleKey: str, ruleValue: str) -> int:
        
        # 1. Get the index in the list based on the ruleKey
        # 2. Count the number of items that match the ruleValue
        # 3. Return the count
        rule_index = 0
        if ruleKey == "color":
            rule_index = 1
        elif ruleKey == "name":
            rule_index = 2
        count = 0
        for item in items:
            if item[rule_index] == ruleValue:
                count += 1
        return count