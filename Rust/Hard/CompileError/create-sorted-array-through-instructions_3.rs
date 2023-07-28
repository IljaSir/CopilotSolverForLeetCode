impl Solution {
    pub fn create_sorted_array(instructions: Vec<i32>) -> i32 {
        
        let mut bit = vec![0; 100001];
        let mut res = 0;
        let mut cost = 0;
        let mut mod_ = 1000000007;
        for i in 0..instructions.len() {
            cost = (cost + std::cmp::min(get(&bit, instructions[i] - 1), i as i32 - get(&bit, instructions[i]))) % mod_;
            update(&mut bit, instructions[i], 1);
        }
        cost
    }
}