impl Solution {
    pub fn length_of_longest_substring(s: String) -> i32 {
        

        let mut map: std::collections::HashMap<char, i32> = std::collections::HashMap::new();
        let mut start = 0;
        let mut max = 0;
        for (i, c) in s.chars().enumerate() {
            if let Some(&j) = map.get(&c) {
                start = start.max(j + 1);
            }
            map.insert(c, i as i32);
            max = max.max(i - start + 1);
        }
        max as i32
    }
}