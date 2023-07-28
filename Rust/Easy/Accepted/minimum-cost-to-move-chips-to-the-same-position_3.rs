impl Solution {
    pub fn min_cost_to_move_chips(position: Vec<i32>) -> i32 {
        
        let mut odd = 0;
        let mut even = 0;
        for i in position {
            if i % 2 == 0 {
                even += 1;
            } else {
                odd += 1;
            }
        }
        if even > odd {
            odd
        } else {
            even
        }
    }
}