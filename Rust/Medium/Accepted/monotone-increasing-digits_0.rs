impl Solution {
    pub fn monotone_increasing_digits(n: i32) -> i32 {
        
        let mut s = n.to_string().chars().collect::<Vec<_>>();
        let mut i = 1;
        while i < s.len() && s[i - 1] <= s[i] {
            i += 1;
        }
        while i > 0 && i < s.len() && s[i - 1] > s[i] {
            s[i - 1] = (s[i - 1] as u8 - 1) as char;
            i -= 1;
        }
        for j in i + 1..s.len() {
            s[j] = '9';
        }
        s.iter().collect::<String>().parse::<i32>().unwrap()
    }
}