class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        
        if len(s) == 0:
            return s
        if len(s) == 1:
            return s
        # create a list of all the characters in s
        s_list = list(s)
        # create a set of all the characters in s
        s_set = set(s)
        # create a list of all the characters in s_set
        s_set_list = list(s_set)
        # sort the list of characters in s_set
        s_set_list.sort()
        # create a list of the indices of the characters in s_set_list in s_list
        s_set_list_index = [s_list.index(s_set_list[i]) for i in range(len(s_set_list))]
        # create a list of the characters in s_set_list in s_list
        s_set_list_s_list = [s_list[i] for i in s_set_list_index]
        # create a list of the characters in s_set_list in s_list that are not in s_set_list
        s_set_list_s_list_not_in_s_set_list = [s_set_list_s_list[i] for i in range(len(s_set_list_s_list)) if s_set_list_s_list[i] not in s_set_list]
        # create