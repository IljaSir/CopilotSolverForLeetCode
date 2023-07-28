impl Solution {
    pub fn largest_palindromic(num: String) -> String {
        
        let mut n = num.len();
        let mut a = num.chars().map(|c| c.to_digit(10).unwrap() as u64).collect::<Vec<_>>();
        a.sort();
        a.reverse();
        let mut b = a.clone();
        b.reverse();
        let mut x = a[0];
        for i in 1..n {
            x = x * 10 + a[i];
        }
        let mut y = b[0];
        for i in 1..n {
            y = y * 10 + b[i];
        }
        while x > y {
            x -= 1;
            y += 1;
            let mut z = x;
            let mut c = 0;
            while z > 0 {
                c += 1;
                z /= 10;
            }
            z = x;
            let mut d = 0;
            for i in 0..c {
                d += (z % 10) * 10u64.pow(i);
                z /= 10;
            }
            if d == y {
                return x.to_string();
            }
        }
        return x.to_string();
    }
}