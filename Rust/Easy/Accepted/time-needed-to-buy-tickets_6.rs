impl Solution {
    pub fn time_required_to_buy(tickets: Vec<i32>, k: i32) -> i32 {
        
        let mut queue: Vec<i32> = tickets;
        let mut time = 0;
        let mut k = k as usize;
        while queue[k] > 0 {
            let mut i = 0;
            while i < queue.len() {
                if queue[i] > 0 {
                    queue[i] -= 1;
                    time += 1;
                    if i == k && queue[k] == 0 {
                        return time;
                    }
                }
                i += 1;
            }
        }
        time
    }
}