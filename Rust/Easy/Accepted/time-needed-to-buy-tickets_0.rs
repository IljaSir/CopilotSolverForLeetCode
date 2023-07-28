impl Solution {
    pub fn time_required_to_buy(tickets: Vec<i32>, k: i32) -> i32 {
        
        let mut tickets = tickets;
        let mut k = k as usize;
        let mut time = 0;
        while tickets[k] > 0 {
            let mut i = 0;
            while i < tickets.len() {
                if tickets[i] > 0 {
                    tickets[i] -= 1;
                    time += 1;
                    if i == k && tickets[i] == 0 {
                        break;
                    }
                }
                i += 1;
            }
        }
        time
    }
}