impl Solution {
    pub fn length_of_longest_substring(s: String) -> i32 {
        

        let mut max = 0;
        let mut start = 0;
        let mut end = 0;
        let mut set: std::collections::HashSet<char> = std::collections::HashSet::new();
        let mut chars = s.chars();
        while let Some(c) = chars.next() {
            while set.contains(&c) {
                set.remove(&s.chars().nth(start).unwrap());
                start += 1;
            }
            set.insert(c);
            end += 1;
            max = std::cmp::max(max, end - start);
        }
        max as i32
    }
}