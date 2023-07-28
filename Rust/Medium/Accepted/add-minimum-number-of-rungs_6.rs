impl Solution {
    pub fn add_rungs(rungs: Vec<i32>, dist: i32) -> i32 {
        
        let mut prev = 0;
        let mut res = 0;
        for r in rungs {
            let diff = r - prev;
            res += (diff - 1) / dist;
            prev = r;
        }
        res
    }
}