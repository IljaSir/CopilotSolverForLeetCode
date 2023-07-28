impl Solution {
    pub fn dist_money(money: i32, children: i32) -> i32 {
        
        if money < children + 1 {
            return -1;
        }
        if money == children + 1 {
            return children;
        }
        let mut children = children;
        let mut money = money;
        while children > 0 {
            if money - 8 < children + 1 {
                break;
            }
            money -= 8;
            children -= 1;
        }
        children
    }
}