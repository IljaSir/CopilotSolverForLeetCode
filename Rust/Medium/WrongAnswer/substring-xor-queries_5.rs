impl Solution {
    pub fn substring_xor_queries(s: String, queries: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut res = vec![];
        for query in queries {
            let mut l = -1;
            let mut r = -1;
            let mut xor = 0;
            for (i, c) in s.chars().enumerate() {
                xor ^= c as i32 - 48;
                if xor == query[1] {
                    if l == -1 {
                        l = i as i32;
                    }
                    r = i as i32;
                }
            }
            res.push(vec![l, r]);
        }
        res
    }
}