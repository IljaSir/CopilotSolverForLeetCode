impl Solution {
    pub fn count_pairs(deliciousness: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut map = std::collections::HashMap::new();
        for d in deliciousness {
            for i in 0..=21 {
                let target = 2_i64.pow(i) - d as i64;
                if let Some(count) = map.get(&target) {
                    res += count;
                }
            }
            *map.entry(d as i64).or_insert(0) += 1;
        }
        res as i32 % 1000000007
    }
}