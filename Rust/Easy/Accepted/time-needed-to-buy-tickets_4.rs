impl Solution {
    pub fn time_required_to_buy(tickets: Vec<i32>, k: i32) -> i32 {
        
        let mut ans = 0;
        let mut queue = tickets.clone();
        let mut k = k as usize;
        while queue[k] > 0 {
            for i in 0..queue.len() {
                if queue[i] > 0 {
                    ans += 1;
                    queue[i] -= 1;
                }
                if i == k && queue[i] == 0 {
                    return ans;
                }
            }
        }
        ans
    }
}