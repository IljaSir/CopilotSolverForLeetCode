impl Solution {
    pub fn dist_money(money: i32, children: i32) -> i32 {
        
        let mut res = 0;
        let mut left = money;
        for i in 1..children {
            if left >= 9 {
                res += 1;
                left -= 9;
            } else {
                break;
            }
        }
        if left >= 8 {
            res += 1;
        }
        res
    }
}