impl Solution {
    pub fn time_required_to_buy(tickets: Vec<i32>, k: i32) -> i32 {
        
        let mut tickets = tickets;
        let mut t = 0;
        let mut k = k as usize;
        while tickets[k] > 0 {
            for i in 0..tickets.len() {
                if tickets[i] > 0 {
                    tickets[i] -= 1;
                    t += 1;
                    if i == k && tickets[i] == 0 {
                        return t;
                    }
                }
            }
        }
        t
    }
}