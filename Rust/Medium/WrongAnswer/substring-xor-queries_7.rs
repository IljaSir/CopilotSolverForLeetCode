impl Solution {
    pub fn substring_xor_queries(s: String, queries: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut res = vec![];
        let mut v = vec![0; s.len()];
        let mut x = 0;
        for (i, c) in s.chars().enumerate() {
            x ^= c.to_digit(2).unwrap() as i32;
            v[i] = x;
        }
        for q in queries {
            let l = q[0] as usize;
            let r = q[1] as usize;
            let mut x = v[r];
            if l > 0 {
                x ^= v[l - 1];
            }
            if x == q[1] {
                res.push(vec![l as i32, r as i32]);
            } else {
                res.push(vec![-1, -1]);
            }
        }
        res
    }
}