impl Solution {
    pub fn add_rungs(rungs: Vec<i32>, dist: i32) -> i32 {
        
        let mut ret = 0;
        let mut cur = 0;
        for r in rungs {
            if r > cur {
                ret += (r - cur - 1) / dist;
                cur = r;
            }
        }
        ret
    }
}