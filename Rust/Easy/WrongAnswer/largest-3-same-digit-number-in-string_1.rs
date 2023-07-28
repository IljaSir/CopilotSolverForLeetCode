impl Solution {
    pub fn largest_good_integer(num: String) -> String {
        
        let mut count = vec![0; 10];
        for c in num.chars() {
            let i = (c as u8 - b'0') as usize;
            count[i] += 1;
        }
        let mut res = String::new();
        for i in (0..10).rev() {
            let c = (i as u8 + b'0') as char;
            let mut n = count[i] / 3;
            while n > 0 {
                res.push(c);
                res.push(c);
                res.push(c);
                n -= 1;
            }
        }
        res
    }
}