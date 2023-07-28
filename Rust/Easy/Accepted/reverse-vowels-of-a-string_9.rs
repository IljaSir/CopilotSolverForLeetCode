impl Solution {
    pub fn reverse_vowels(s: String) -> String {
        
        let mut s: Vec<char> = s.chars().collect();
        let mut vowels: Vec<char> = s.iter().filter(|&v| "aeiouAEIOU".contains(*v)).cloned().collect();
        for i in 0..s.len() {
            if "aeiouAEIOU".contains(s[i]) {
                s[i] = vowels.pop().unwrap();
            }
        }
        s.iter().collect()
    }
}