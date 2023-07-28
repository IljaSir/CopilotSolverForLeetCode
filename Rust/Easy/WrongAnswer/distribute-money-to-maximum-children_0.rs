impl Solution {
    pub fn dist_money(money: i32, children: i32) -> i32 {
        
        let mut res = -1;
        for i in 1..children {
            if money - (i * 8) >= (children - i) {
                res = i;
            }
        }
        res
    }
}