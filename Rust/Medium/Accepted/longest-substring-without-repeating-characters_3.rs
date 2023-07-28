impl Solution {
    pub fn length_of_longest_substring(s: String) -> i32 {
        

        let mut left = 0;
        let mut right = 0;
        let mut max = 0;
        let mut set = std::collections::HashSet::new();
        while right < s.len() {
            if !set.contains(&s[right..right+1]) {
                set.insert(s[right..right+1].to_string());
                right += 1;
                max = std::cmp::max(max, right - left);
            } else {
                set.remove(&s[left..left+1]);
                left += 1;
            }
        }
        max as i32
    }
}