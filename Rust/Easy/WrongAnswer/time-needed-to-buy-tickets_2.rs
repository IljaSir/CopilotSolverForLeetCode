impl Solution {
    pub fn time_required_to_buy(tickets: Vec<i32>, k: i32) -> i32 {
        
        let mut queue = tickets;
        let mut time = 0;
        while queue[k as usize] > 0 {
            let front = queue.remove(0);
            if front > 0 {
                queue.push(front - 1);
            }
            time += 1;
        }
        time
    }
}