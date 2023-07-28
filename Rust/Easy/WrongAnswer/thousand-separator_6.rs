impl Solution {
    pub fn thousand_separator(n: i32) -> String {
        
        let mut s = String::from("");
        let mut n = n;
        let mut count = 0;
        while n > 0 {
            if count % 3 == 0 && count > 0 {
                s = ".".to_string() + &s;
            }
            s = (n % 10).to_string() + &s;
            n /= 10;
            count += 1;
        }
        s
    }
}