impl Solution {
    pub fn length_of_longest_substring(s: String) -> i32 {
        

        let mut chars = s.chars();
        let mut max = 0;
        let mut start = 0;
        let mut end = 1;
        let mut map = std::collections::HashMap::new();
        map.insert(chars.next().unwrap(), 0);
        for c in chars {
            if let Some(&i) = map.get(&c) {
                if i >= start {
                    start = i + 1;
                }
            }
            map.insert(c, end);
            end += 1;
            max = std::cmp::max(max, end - start);
        }
        max as i32
    }
}