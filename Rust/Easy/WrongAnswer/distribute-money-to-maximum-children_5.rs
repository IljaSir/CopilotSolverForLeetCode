impl Solution {
    pub fn dist_money(money: i32, children: i32) -> i32 {
        
        let mut result = 0;
        for i in 1..children {
            let sum = 8 * i + (i + 1) * i / 2;
            if sum <= money {
                result = i;
            }
        }
        if result == 0 {
            return -1;
        }
        result
    }
}