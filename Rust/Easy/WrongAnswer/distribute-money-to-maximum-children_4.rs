impl Solution {
    pub fn dist_money(money: i32, children: i32) -> i32 {
        
        if money < children {
            return -1;
        }
        if money - children * 3 < 0 {
            return -1;
        }
        (money - children * 3) / 4
    }
}