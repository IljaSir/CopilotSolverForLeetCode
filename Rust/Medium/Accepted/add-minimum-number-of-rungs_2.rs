impl Solution {
    pub fn add_rungs(rungs: Vec<i32>, dist: i32) -> i32 {
        
        let mut ans = 0;
        let mut prev = 0;
        for i in 0..rungs.len() {
            ans += (rungs[i] - prev - 1) / dist;
            prev = rungs[i];
        }
        ans
    }
}