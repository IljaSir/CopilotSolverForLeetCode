impl Solution {
    pub fn two_egg_drop(n: i32) -> i32 {
        
        let mut k = 0;
        let mut i = 1;
        while i < n {
            i += i + 1;
            k += 1;
        }
        k
    }
}