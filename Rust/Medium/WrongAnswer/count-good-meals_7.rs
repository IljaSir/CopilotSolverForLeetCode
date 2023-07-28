impl Solution {
    pub fn count_pairs(deliciousness: Vec<i32>) -> i32 {
        
        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        for i in deliciousness {
            let mut j = 1;
            while j <= i << 10 {
                if let Some(c) = map.get(&(j - i)) {
                    count += c;
                    count %= 1000000007;
                }
                j <<= 1;
            }
            *map.entry(i).or_default() += 1;
        }
        count as i32
    }
}