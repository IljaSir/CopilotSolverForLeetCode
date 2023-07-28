impl Solution {
    pub fn smallest_good_base(n: String) -> String {
        
        let n: u64 = n.parse().unwrap();
        let mut res: u64 = n - 1;
        for m in 59..1 {
            let k = (n as f64).powf(1.0 / m as f64) as u64;
            if k > 1 {
                let mut mul: u64 = 1;
                let mut sum: u64 = 1;
                for _ in 0..m {
                    mul *= k;
                    sum += mul;
                }
                if sum == n {
                    res = k;
                }
            }
        }
        res.to_string()
    }
}