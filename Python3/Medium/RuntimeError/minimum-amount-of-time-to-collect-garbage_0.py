class Solution:
    def garbageCollection(self, garbage: List[str], travel: List[int]) -> int:
        
        
        def get_garbage_type(garbage):
            if 'M' in garbage:
                return 'M'
            if 'P' in garbage:
                return 'P'
            if 'G' in garbage:
                return 'G'
        
        def get_garbage_type_index(garbage, garbage_type):
            if garbage_type == 'M':
                return garbage.index('M')
            if garbage_type == 'P':
                return garbage.index('P')
            if garbage_type == 'G':
                return garbage.index('G')
        
        def get_garbage_type_count(garbage):
            return garbage.count('M'), garbage.count('P'), garbage.count('G')
        
        def get_garbage_type_count_total(garbage_type_count):
            return sum(garbage_type_count)
        
        def get_garbage_type_count_total_except(garbage_type_count, garbage_type):
            if garbage_type == 'M':
                return garbage_type_count[1] + garbage_type_count[2]
            if garbage_type == 'P':
                return garbage_type_count[0] + garbage_type_count[2]
            if garbage_type == 'G':
                return garbage_type_count[0] + garbage_type_count[1]
        
        def get_garbage_type_count_except(garbage, garbage_type):
            if garbage_type == 'M':
                return garbage.count('P'), garbage.count('G')
            if garbage_type == 'P':
                return garbage.count('M'), garbage.count('G')
            if garbage_type == 'G':
                return garbage.count('M'), garbage.count('P')
        
        def get_garbage_type_count_except_total(garbage_type_count_except):
            return sum(garbage_type_count_except)
        
        def get_garbage_type_count_except_total_except(garbage_type_count_except, garbage_type):
            if garbage_type == 'M':
                return garbage_type_count_except[1]
            if garbage_type == 'P':
                return garbage_type_count_except[0]
            if garbage_type == 'G':
                return garbage_type_count_except[0]
        
        def get_garbage_type_count_except_total_except_index(garbage_type_count_except, garbage_type, index):
            if garbage_type == 'M':
                return garbage_type_count_except[1][index]
            if garbage_type == 'P':
                return garbage_type_count_except[0][index]
            if