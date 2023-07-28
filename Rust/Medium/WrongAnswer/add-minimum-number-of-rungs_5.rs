impl Solution {
    pub fn add_rungs(rungs: Vec<i32>, dist: i32) -> i32 {
        
        let mut sum = 0;
        for i in 1..rungs.len() {
            let diff = rungs[i] - rungs[i - 1];
            sum += (diff - 1) / dist;
        }
        sum
    }
}