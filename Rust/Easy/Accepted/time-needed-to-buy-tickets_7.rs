impl Solution {
    pub fn time_required_to_buy(tickets: Vec<i32>, k: i32) -> i32 {
        
        let n = tickets.len();
        let mut time = 0;
        let mut queue = tickets;
        while queue[k as usize] > 0 {
            let mut i = 0;
            while i < n {
                if queue[i] > 0 {
                    queue[i] -= 1;
                    time += 1;
                    if i == k as usize && queue[i] == 0 {
                        return time;
                    }
                }
                i += 1;
            }
        }
        time
    }
}