class Solution:
    def smallestSufficientTeam(self, req_skills: List[str], people: List[List[str]]) -> List[int]:
        
        # create a dictionary with skills and indices
        skill_to_index = {skill: index for index, skill in enumerate(req_skills)}
        # create a dictionary with people and skills
        people_to_skills = {index: set() for index, person in enumerate(people)}
        for index, person in enumerate(people):
            for skill in person:
                people_to_skills[index].add(skill_to_index[skill])
        # create a dictionary with skills and people
        skills_to_people = {skill: set() for skill in range(len(req_skills))}
        for index, person in enumerate(people):
            for skill in person:
                skills_to_people[skill_to_index[skill]].add(index)
        # create a dictionary with people and skills
        people_to_skills = {index: set() for index, person in enumerate(people)}
        for index, person in enumerate(people):
            for skill in person:
                people_to_skills[index].add(skill_to_index[skill])
        # create a dictionary with people and skills
        people_to_skills = {index: set() for index, person in enumerate(people)}
        for index, person in enumerate(people):
            for skill in person:
                people_to_skills[index].add(skill_to_index[skill])
        # create a dictionary with people and skills
        people_to_skills = {index: set() for index, person in enumerate(people)}
        for index, person in enumerate(people):
            for skill in person:
                people_to_skills[index].add(skill_to_index[skill])
        # create a dictionary with people and skills
        people_to_skills = {index: set() for index, person in enumerate(people)}
        for index, person in enumerate(people):
            for skill in person:
                people_to_skills[index].add(skill_to_index[skill])
        # create a dictionary with people and skills
        people_to_skills = {index: set() for index, person in enumerate(people)}
        for index, person in enumerate(people):
            for skill in person:
                people_to_skills[index].add(skill_to_index[skill])
        # create a dictionary with people and skills
        people_to_skills = {index: set() for index, person in enumerate(people)}
        for index, person in enumerate(people):
            for skill in person:
                people_to_skills[index].add(skill_to_index[skill])
        # create a dictionary with people