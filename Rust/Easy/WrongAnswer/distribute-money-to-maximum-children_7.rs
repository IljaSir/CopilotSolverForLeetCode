impl Solution {
    pub fn dist_money(money: i32, children: i32) -> i32 {
        
        let mut money = money;
        let mut children = children;
        let mut max = 0;
        while money >= children + 1 && children > 1 {
            money -= 8;
            children -= 1;
            max += 1;
        }
        if money < children + 1 {
            -1
        } else {
            max
        }
    }
}