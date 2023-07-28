impl Solution {
    pub fn best_closing_time(customers: String) -> i32 {
        
        let mut cnt = 0;
        let mut res = 0;
        for i in 0..customers.len() {
            if customers.as_bytes()[i] == b'N' {
                cnt += 1;
                if cnt > res {
                    res = cnt;
                }
            } else {
                cnt = 0;
            }
        }
        res
    }
}