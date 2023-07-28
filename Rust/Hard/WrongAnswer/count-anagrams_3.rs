impl Solution {
    pub fn count_anagrams(s: String) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        let mut ret = 1;
        let mut modu = 1_000_000_007;
        for c in s.chars() {
            if c == ' ' {
                let mut tmp = 0;
                for v in map.values() {
                    tmp += v * (v - 1) / 2;
                    tmp %= modu;
                }
                ret *= tmp + 1;
                ret %= modu;
                map.clear();
            } else {
                *map.entry(c).or_insert(0) += 1;
            }
        }
        let mut tmp = 0;
        for v in map.values() {
            tmp += v * (v - 1) / 2;
            tmp %= modu;
        }
        ret *= tmp + 1;
        ret %= modu;
        ret
    }
}