impl Solution {
    pub fn wonderful_substrings(word: String) -> i64 {
        
        let mut res = 0;
        let mut map = std::collections::HashMap::new();
        map.insert(0, 1);
        let mut mask = 0;
        for c in word.chars() {
            mask ^= 1 << (c as u8 - 'a' as u8);
            res += map.get(&mask).unwrap_or(&0);
            for i in 0..10 {
                res += map.get(&(mask ^ (1 << i))).unwrap_or(&0);
            }
            *map.entry(mask).or_insert(0) += 1;
        }
        res
    }
}