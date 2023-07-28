impl Solution {
    pub fn dist_money(money: i32, children: i32) -> i32 {
        
        if money < 2 * children {
            return -1;
        }
        let mut ans = 0;
        for i in 2..=children {
            let mut x = money - i;
            if x % (children + 1) == 0 {
                ans += 1;
            }
        }
        ans
    }
}