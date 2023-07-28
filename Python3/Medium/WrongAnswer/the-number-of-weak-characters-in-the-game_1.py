class Solution:
    def numberOfWeakCharacters(self, properties: List[List[int]]) -> int:
        
        # 1. sort properties by attack
        # 2. for each attack, find the max defense
        # 3. if attack is greater than attack of previous attack, then check if defense of previous attack is greater than the max defense
        # 4. if defense of previous attack is greater than the max defense, then increment the count
        properties.sort(key=lambda x: x[0])
        max_defense = 0
        count = 0
        for attack, defense in properties:
            if attack > max_defense:
                max_defense = defense
            elif defense < max_defense:
                count += 1
        return count