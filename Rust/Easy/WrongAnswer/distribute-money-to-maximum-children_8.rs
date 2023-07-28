impl Solution {
    pub fn dist_money(money: i32, children: i32) -> i32 {
        
        let mut x = money - children;
        if x < 3 {
            return -1;
        } else if x == 3 {
            return 0;
        }
        x -= 3;
        let mut y = x / 7;
        if y > children - 1 {
            y = children - 1;
        }
        y
    }
}