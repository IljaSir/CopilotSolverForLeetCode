impl Solution {
    pub fn reverse_vowels(s: String) -> String {
        
        let mut s = s.chars().collect::<Vec<char>>();
        let vowels = vec!['a', 'e', 'i', 'o', 'u'];
        let mut left = 0;
        let mut right = s.len() - 1;
        while left < right {
            if vowels.contains(&s[left].to_ascii_lowercase()) && vowels.contains(&s[right].to_ascii_lowercase()) {
                s.swap(left, right);
                left += 1;
                right -= 1;
            } else if vowels.contains(&s[left].to_ascii_lowercase()) {
                right -= 1;
            } else if vowels.contains(&s[right].to_ascii_lowercase()) {
                left += 1;
            } else {
                left += 1;
                right -= 1;
            }
        }
        s.iter().collect()
    }
}