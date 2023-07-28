impl Solution {
    pub fn largest_good_integer(num: String) -> String {
        
        let mut count = [0; 10];
        for c in num.chars() {
            let n = c as u8 - b'0';
            count[n as usize] += 1;
        }
        let mut res = String::new();
        for i in (1..=9).rev() {
            while count[i] > 0 {
                res.push((i + b'0') as char);
                count[i] -= 1;
            }
        }
        res
    }
}