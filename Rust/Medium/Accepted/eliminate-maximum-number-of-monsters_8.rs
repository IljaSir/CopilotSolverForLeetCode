impl Solution {
    pub fn eliminate_maximum(dist: Vec<i32>, speed: Vec<i32>) -> i32 {
        
        let mut t = dist.iter().zip(speed.iter()).map(|(d, s)| (d - 1) / s).collect::<Vec<_>>();
        t.sort();
        let mut i = 0;
        while i < t.len() && t[i] >= i as i32 {
            i += 1;
        }
        i as i32
    }
}