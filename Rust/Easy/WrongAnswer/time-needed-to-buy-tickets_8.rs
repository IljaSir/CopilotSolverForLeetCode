impl Solution {
    pub fn time_required_to_buy(tickets: Vec<i32>, k: i32) -> i32 {
        
        let mut sum = 0;
        let mut max = 0;
        for i in 0..tickets.len() {
            if i == k as usize {
                sum += tickets[i];
            } else {
                let mut cur = tickets[i];
                while cur > 0 {
                    cur -= 1;
                    sum += 1;
                    if cur > max {
                        max = cur;
                    }
                }
            }
        }
        sum + max
    }
}