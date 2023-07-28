impl Solution {
    pub fn time_required_to_buy(tickets: Vec<i32>, k: i32) -> i32 {
        
        let mut v = tickets.clone();
        let mut t = 0;
        let mut i = k as usize;
        let mut m = 0;
        while v.iter().any(|&x| x > 0) {
            if v[i] > 0 {
                v[i] -= 1;
                t += 1;
            }
            if i == v.len() - 1 {
                m = t;
            } else if i == 0 {
                m = m.max(t);
            }
            i = (i + 1) % v.len();
        }
        m
    }
}