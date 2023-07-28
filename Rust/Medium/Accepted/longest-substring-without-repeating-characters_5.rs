impl Solution {
    pub fn length_of_longest_substring(s: String) -> i32 {
        

        let mut max = 0;
        let mut start = 0;
        let mut map = std::collections::HashMap::new();
        let chars: Vec<char> = s.chars().collect();
        for i in 0..chars.len() {
            if let Some(&j) = map.get(&chars[i]) {
                if j >= start {
                    start = j + 1;
                }
            }
            map.insert(chars[i], i);
            max = std::cmp::max(max, i - start + 1);
        }
        max as i32
    }
}