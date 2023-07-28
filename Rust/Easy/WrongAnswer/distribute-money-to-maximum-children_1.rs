impl Solution {
    pub fn dist_money(money: i32, children: i32) -> i32 {
        
        let mut res = 0;
        let mut m = money;
        for i in 0..children {
            if m < 8 {
                break;
            }
            m -= 8;
            res += 1;
        }
        if m >= 8 {
            return -1;
        }
        res
    }
}