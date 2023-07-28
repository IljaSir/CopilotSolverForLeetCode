impl Solution {
    pub fn fraction_to_decimal(numerator: i32, denominator: i32) -> String {
        

        let mut n = numerator as i64;
        let mut d = denominator as i64;
        let mut res = String::new();
        if n * d < 0 {
            res.push('-');
        }
        n = n.abs();
        d = d.abs();
        res.push_str(&(n / d).to_string());
        n %= d;
        if n == 0 {
            return res;
        }
        res.push('.');
        let mut pos = res.len();
        let mut map = std::collections::HashMap::new();
        while n != 0 {
            if map.contains_key(&n) {
                res.insert(map[&n], '(');
                res.push(')');
                break;
            }
            map.insert(n, pos);
            n *= 10;
            res.push_str(&(n / d).to_string());
            n %= d;
            pos += 1;
        }
        res
    }
}