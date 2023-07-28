impl Solution {
    pub fn ways_to_buy_pens_pencils(total: i32, cost1: i32, cost2: i32) -> i64 {
        
        let mut ways = 0;
        for i in 0..=total {
            if i * cost1 > total {
                break;
            }
            if (total - i * cost1) % cost2 == 0 {
                ways += 1;
            }
        }
        ways
    }
}