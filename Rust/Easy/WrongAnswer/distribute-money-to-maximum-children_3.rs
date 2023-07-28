impl Solution {
    pub fn dist_money(money: i32, children: i32) -> i32 {
        
        let mut m = money - children;
        if m < 0 || m % 3 != 0 {
            return -1;
        }
        m /= 3;
        if m > 8 {
            m = 8;
        }
        m
    }
}