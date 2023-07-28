impl Solution {
    pub fn nearest_palindromic(n: String) -> String {
        
        let mut n: i64 = n.parse().unwrap();
        let mut v: Vec<i64> = vec![0, 1, -1, 10, -10, 100, -100, 1000, -1000, 10000, -10000, 100000, -100000, 1000000, -1000000, 10000000, -10000000, 100000000, -100000000, 1000000000, -1000000000, 10000000000, -10000000000];
        if n == 1 {
            return "0".to_string();
        }
        let mut min = n;
        let mut diff = min - 0;
        let mut min_diff = diff;
        for i in 0..v.len() {
            let mut num = n + v[i];
            if num == 0 {
                continue;
            }
            let mut rev = 0;
            let mut num2 = num;
            while num2 > 0 {
                rev = rev * 10 + num2 % 10;
                num2 /= 10;
            }
            if rev == num {
                return rev.to_string();
            }
            diff = rev - num;
            if diff < 0 {
                diff = diff * -1;
            }
            if diff < min_diff {
                min_diff = diff;
                min = rev;
            } else if diff == min_diff && rev < min {
                min = rev;
            }
        }
        min.to_string()
    }
}