class Solution:
    def fillCups(self, amount: List[int]) -> int:
        
        def get_problem_level(all_problems, problem_name):
            for level, problems in all_problems.items():
                if problem_name in problems:
                    return level
            return -1
        return get_problem_level(all_problems, "fill-cups")