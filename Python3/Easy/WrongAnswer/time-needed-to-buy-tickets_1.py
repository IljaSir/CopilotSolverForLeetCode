class Solution:
    def timeRequiredToBuy(self, tickets: List[int], k: int) -> int:
        
        # Find the max number of tickets
        max_tickets = max(tickets)
        # Find the number of people who want max_tickets
        max_tickets_people = tickets.count(max_tickets)
        # Number of people who want less than max_tickets
        less_than_max_tickets = len(tickets) - max_tickets_people
        # If k is in the max_tickets_people
        if tickets[k] == max_tickets:
            return max_tickets + less_than_max_tickets
        # If k is not in the max_tickets_people
        else:
            return max_tickets + less_than_max_tickets + 1