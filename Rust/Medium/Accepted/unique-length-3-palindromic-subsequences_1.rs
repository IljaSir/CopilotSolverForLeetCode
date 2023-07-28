impl Solution {
    pub fn count_palindromic_subsequence(s: String) -> i32 {
        
        let mut count = 0;
        let s: Vec<char> = s.chars().collect();
        for c in 'a'..='z' {
            let mut left = 0;
            let mut right = s.len() - 1;
            while left < s.len() && s[left] != c {
                left += 1;
            }
            while right > 0 && s[right] != c {
                right -= 1;
            }
            if left < right {
                let mut set = std::collections::HashSet::new();
                for i in left + 1..right {
                    set.insert(s[i]);
                }
                count += set.len();
            }
        }
        count as i32
    }
}