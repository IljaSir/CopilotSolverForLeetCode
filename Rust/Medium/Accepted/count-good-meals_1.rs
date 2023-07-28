impl Solution {
    pub fn count_pairs(deliciousness: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        let mut count = 0;
        for d in deliciousness {
            for i in 0..22 {
                let target = 1 << i;
                if let Some(v) = map.get(&(target - d)) {
                    count += v;
                    count %= 1000000007;
                }
            }
            *map.entry(d).or_insert(0) += 1;
        }
        count
    }
}