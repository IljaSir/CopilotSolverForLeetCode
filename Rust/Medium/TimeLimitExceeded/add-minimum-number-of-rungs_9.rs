impl Solution {
    pub fn add_rungs(rungs: Vec<i32>, dist: i32) -> i32 {
        
        let mut ans = 0;
        let mut pre = 0;
        for i in rungs {
            let mut gap = i - pre;
            while gap > dist {
                gap -= dist;
                ans += 1;
            }
            pre = i;
        }
        ans
    }
}