impl Solution {
    pub fn get_happy_string(n: i32, k: i32) -> String {
        
        let mut res = String::new();
        let mut left = k;
        let mut cur = String::from("a");
        for i in 1..n {
            let mut next = String::new();
            for c in cur.chars() {
                for j in 0..3 {
                    let next_c = (b'a' + j) as char;
                    if next_c != c {
                        next.push(next_c);
                    }
                }
            }
            cur = next;
        }
        if left > cur.len() as i32 {
            return res;
        }
        res = cur.chars().nth((left - 1) as usize).unwrap().to_string();
        res
    }
}