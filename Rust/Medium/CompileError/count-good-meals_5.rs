impl Solution {
    pub fn count_pairs(deliciousness: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut map = std::collections::HashMap::new();
        for &x in deliciousness.iter() {
            for i in 0..21 {
                ans += map.get(&(1 << i) - x).unwrap_or(&0);
            }
            *map.entry(x).or_insert(0) += 1;
        }
        (ans % 1000000007) as i32
    }
}