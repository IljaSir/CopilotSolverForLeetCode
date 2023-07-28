impl Solution {
    pub fn two_egg_drop(n: i32) -> i32 {
        
        let mut drops = 0;
        let mut f = 1;
        while f < n {
            drops += 1;
            f += drops;
        }
        drops
    }
}