impl Solution {
    pub fn count_pairs(deliciousness: Vec<i32>) -> i32 {
        
        let mut cnt = std::collections::HashMap::new();
        let mut ans = 0i64;
        for &x in deliciousness.iter() {
            for k in 0..22 {
                if let Some(&y) = cnt.get(&(1 << k - x)) {
                    ans += y;
                }
            }
            *cnt.entry(x).or_insert(0) += 1;
        }
        (ans % 1000000007) as i32
    }
}