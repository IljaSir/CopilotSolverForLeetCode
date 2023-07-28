impl Solution {
    pub fn count_pairs(deliciousness: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        let mut ans = 0;
        let mod_num = 1_000_000_007;
        for i in 0..=21 {
            let k = 1 << i;
            for &delicious in &deliciousness {
                if let Some(&v) = map.get(&(k - delicious)) {
                    ans += v;
                    ans %= mod_num;
                }
                *map.entry(delicious).or_default() += 1;
            }
        }
        ans
    }
}