impl Solution {
    pub fn time_required_to_buy(tickets: Vec<i32>, k: i32) -> i32 {
        
        let mut queue: Vec<i32> = tickets.clone();
        let mut time = 0;
        let mut k = k as usize;
        while queue[k] > 0 {
            let ticket = queue.remove(0);
            if ticket > 0 {
                queue.push(ticket - 1);
            }
            time += 1;
            if k > 0 {
                k -= 1;
            } else {
                k = queue.len() - 1;
            }
        }
        time
    }
}