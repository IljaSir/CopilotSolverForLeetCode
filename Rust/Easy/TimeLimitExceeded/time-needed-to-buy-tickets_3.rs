impl Solution {
    pub fn time_required_to_buy(tickets: Vec<i32>, k: i32) -> i32 {
        
        let mut k = k as usize;
        let mut tickets = tickets;
        let mut time = 0;
        let mut max = 0;
        for i in 0..tickets.len() {
            max = std::cmp::max(max, tickets[i]);
        }
        let mut i = 0;
        while i < max {
            for j in 0..tickets.len() {
                if tickets[j] > 0 {
                    tickets[j] -= 1;
                    time += 1;
                    if k == j {
                        i += 1;
                    }
                }
            }
        }
        time
    }
}