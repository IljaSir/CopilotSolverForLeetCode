impl Solution {
    pub fn ways_to_buy_pens_pencils(total: i32, cost1: i32, cost2: i32) -> i64 {
        
        let mut ans = 0;
        for i in 0..=total {
            let j = total - i;
            if i % cost1 == 0 && j % cost2 == 0 {
                ans += 1;
            }
        }
        ans
    }
}