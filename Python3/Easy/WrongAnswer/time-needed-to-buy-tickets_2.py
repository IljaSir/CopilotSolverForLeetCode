class Solution:
    def timeRequiredToBuy(self, tickets: List[int], k: int) -> int:
        
        # Get the number of tickets for the person at position k
        tickets_for_k = tickets[k]
        # Get the sum of all tickets
        total_tickets = sum(tickets)
        # The total time is the number of tickets for k + the number of passes for the remaining tickets
        return tickets_for_k + (total_tickets - tickets_for_k) // (len(tickets) - 1)