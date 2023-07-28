impl Solution {
    pub fn length_of_longest_substring(s: String) -> i32 {
        

        let mut max = 0;
        let mut start = 0;
        let mut map = std::collections::HashMap::new();
        for (i, c) in s.chars().enumerate() {
            if let Some(&j) = map.get(&c) {
                max = std::cmp::max(max, i - start);
                start = std::cmp::max(start, j + 1);
            }
            map.insert(c, i);
        }
        std::cmp::max(max, s.len() - start) as i32
    }
}