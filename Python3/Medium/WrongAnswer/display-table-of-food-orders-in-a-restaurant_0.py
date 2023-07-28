class Solution:
    def displayTable(self, orders: List[List[str]]) -> List[List[str]]:
        table_set = set()
        food_set = set()
        for order in orders:
            table_set.add(order[1])
            food_set.add(order[2])
        table_set = list(table_set)
        food_set = list(food_set)
        table_set.sort()
        food_set.sort()
        table_dict = {}
        for table in table_set:
            table_dict[table] = {}
            for food in food_set:
                table_dict[table][food] = 0
        for order in orders:
            table_dict[order[1]][order[2]] += 1
        table_list = []
        table_list.append(["Table"] + food_set)
        for table in table_set:
            table_list.append([table] + [str(table_dict[table][food]) for food in food_set])
        return table_list