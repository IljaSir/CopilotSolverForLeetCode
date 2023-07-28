impl Solution {
    pub fn longest_palindrome(s: String) -> String {
        

        let mut s = s.chars().collect::<Vec<char>>();
        let mut max_len = 0;
        let mut start = 0;
        let mut end = 0;
        for i in 0..s.len() {
            let mut j = i;
            let mut k = i;
            while j > 0 && s[j] == s[j-1] {
                j -= 1;
            }
            while k < s.len()-1 && s[k] == s[k+1] {
                k += 1;
            }
            while j > 0 && k < s.len()-1 && s[j-1] == s[k+1] {
                j -= 1;
                k += 1;
            }
            if k - j + 1 > max_len {
                max_len = k - j + 1;
                start = j;
                end = k;
            }
        }
        s[start..=end].iter().collect::<String>()
    }
}