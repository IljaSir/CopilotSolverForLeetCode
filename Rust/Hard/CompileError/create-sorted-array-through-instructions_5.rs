impl Solution {
    pub fn create_sorted_array(instructions: Vec<i32>) -> i32 {
        
        let mut bit = BIT::new(100_001);
        let mut cost = 0;
        for (i, &val) in instructions.iter().enumerate() {
            let less = bit.query(val - 1);
            let greater = i as i32 - bit.query(val);
            cost += std::cmp::min(less, greater);
            bit.update(val, 1);
        }
        cost as i32 % 1_000_000_007
    }
}