impl Solution {
    pub fn count_pairs(deliciousness: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        let mut res = 0;
        for d in deliciousness {
            for i in 0..=21 {
                let diff = 1 << i - d;
                if let Some(count) = map.get(&diff) {
                    res = (res + count) % 1000000007;
                }
            }
            *map.entry(d).or_insert(0) += 1;
        }
        res
    }
}