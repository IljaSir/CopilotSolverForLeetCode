impl Solution {
    pub fn ways_to_buy_pens_pencils(total: i32, cost1: i32, cost2: i32) -> i64 {
        
        let (cost1, cost2) = (cost1 as i64, cost2 as i64);
        let total = total as i64;
        let mut res = 0;
        for i in 0..=total / cost1 {
            let j = (total - i * cost1) / cost2;
            res += j + 1;
        }
        res
    }
}