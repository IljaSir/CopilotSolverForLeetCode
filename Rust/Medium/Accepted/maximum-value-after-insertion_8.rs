impl Solution {
    pub fn max_value(n: String, x: i32) -> String {
        
        let (mut i, mut sign) = (0, 1);
        let mut n = n;
        if n.starts_with('-') {
            sign = -1;
            n = n[1..].to_string();
        }
        if sign == 1 {
            while i < n.len() && n[i..i+1].parse::<i32>().unwrap() >= x {
                i += 1;
            }
        } else {
            while i < n.len() && n[i..i+1].parse::<i32>().unwrap() <= x {
                i += 1;
            }
        }
        n.insert_str(i, &x.to_string());
        if sign == -1 {
            n.insert_str(0, "-");
        }
        n
    }
}