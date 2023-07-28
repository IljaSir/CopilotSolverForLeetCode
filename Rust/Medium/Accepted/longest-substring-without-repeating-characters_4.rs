impl Solution {
    pub fn length_of_longest_substring(s: String) -> i32 {
        

        let mut max = 0;
        let mut left = 0;
        let mut right = 0;
        let mut map = std::collections::HashMap::new();
        for c in s.chars() {
            if let Some(&i) = map.get(&c) {
                left = left.max(i+1);
            }
            map.insert(c, right);
            right += 1;
            max = max.max(right - left);
        }
        max as i32
    }
}