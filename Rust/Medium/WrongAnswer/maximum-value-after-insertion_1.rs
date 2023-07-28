impl Solution {
    pub fn max_value(n: String, x: i32) -> String {
        
        let mut v = n.chars().collect::<Vec<char>>();
        let x = x as u8;
        if v[0] == '-' {
            for i in 1..v.len() {
                if v[i] > x as char {
                    v.insert(i, x as char);
                    return v.into_iter().collect();
                }
            }
        } else {
            for i in 0..v.len() {
                if v[i] < x as char {
                    v.insert(i, x as char);
                    return v.into_iter().collect();
                }
            }
        }
        v.push(x as char);
        v.into_iter().collect()
    }
}