impl Solution {
    pub fn count_pairs(deliciousness: Vec<i32>) -> i32 {
        
        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        for &i in deliciousness.iter() {
            for j in 0..22 {
                let k = 2_i32.pow(j) - i;
                if let Some(&v) = map.get(&k) {
                    count += v;
                    count %= 1_000_000_007;
                }
            }
            *map.entry(i).or_default() += 1;
        }
        count as i32
    }
}