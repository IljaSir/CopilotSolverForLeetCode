impl Solution {
    pub fn monotone_increasing_digits(n: i32) -> i32 {
        
        let mut n = n.to_string().chars().collect::<Vec<char>>();
        let mut i = 1;
        while i < n.len() && n[i - 1] <= n[i] {
            i += 1;
        }
        if i < n.len() {
            while i > 0 && n[i - 1] > n[i] {
                n[i - 1] = (n[i - 1] as u8 - 1) as char;
                i -= 1;
            }
            for j in (i + 1)..n.len() {
                n[j] = '9';
            }
        }
        n.iter().collect::<String>().parse::<i32>().unwrap()
    }
}