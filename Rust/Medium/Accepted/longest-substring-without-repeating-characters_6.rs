impl Solution {
    pub fn length_of_longest_substring(s: String) -> i32 {
        

        let mut max = 0;
        let mut start = 0;
        let mut end = 0;
        let mut set = std::collections::HashSet::new();
        while end < s.len() {
            if !set.contains(&s[end..end + 1]) {
                set.insert(s[end..end + 1].to_owned());
                end += 1;
                max = max.max(end - start);
            } else {
                set.remove(&s[start..start + 1]);
                start += 1;
            }
        }
        max as i32
    }
}