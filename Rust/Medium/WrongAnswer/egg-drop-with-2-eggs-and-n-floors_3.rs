impl Solution {
    pub fn two_egg_drop(n: i32) -> i32 {
        
        let n = n as usize;
        let mut f = vec![0; n + 1];
        let mut i = 1;
        while f[i] < n {
            i += 1;
            f[i] = i + f[i - 1];
        }
        i as i32
    }
}