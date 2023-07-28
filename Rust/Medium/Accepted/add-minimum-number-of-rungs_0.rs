impl Solution {
    pub fn add_rungs(rungs: Vec<i32>, dist: i32) -> i32 {
        
        let mut ans = 0;
        let mut last = 0;
        for &r in rungs.iter() {
            ans += (r - last - 1) / dist;
            last = r;
        }
        ans
    }
}