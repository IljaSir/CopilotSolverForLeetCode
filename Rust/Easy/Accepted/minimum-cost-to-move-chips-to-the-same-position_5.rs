impl Solution {
    pub fn min_cost_to_move_chips(position: Vec<i32>) -> i32 {
        
        let mut even = 0;
        let mut odd = 0;
        for &p in position.iter() {
            if p % 2 == 0 {
                even += 1;
            } else {
                odd += 1;
            }
        }
        std::cmp::min(even, odd)
    }
}