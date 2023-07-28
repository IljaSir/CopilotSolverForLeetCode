impl Solution {
    pub fn eliminate_maximum(dist: Vec<i32>, speed: Vec<i32>) -> i32 {
        
        let mut v = dist.iter().zip(speed.iter()).map(|(d, s)| (d + s - 1) / s).collect::<Vec<i32>>();
        v.sort();
        let mut t = 0;
        for (i, d) in v.iter().enumerate() {
            if i as i32 >= *d {
                return i as i32;
            }
        }
        v.len() as i32
    }
}