impl Solution {
    pub fn distinct_integers(n: i32) -> i32 {
        
        let n = n as usize;
        let mut v = vec![0; n + 1];
        for i in 1..=n {
            for j in i..=n {
                if j % i == 1 {
                    v[j] += 1;
                }
            }
        }
        v.into_iter().filter(|x| *x == 1).count() as i32
    }
}