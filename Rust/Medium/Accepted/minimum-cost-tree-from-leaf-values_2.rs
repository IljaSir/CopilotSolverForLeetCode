impl Solution {
    pub fn mct_from_leaf_values(arr: Vec<i32>) -> i32 {
        
        let mut s = vec![std::i32::MAX];
        let mut res = 0;
        for a in arr {
            while s.last().unwrap() <= &a {
                let mid = s.pop().unwrap();
                res += mid * std::cmp::min(s.last().unwrap(), &a);
            }
            s.push(a);
        }
        while s.len() > 2 {
            res += s.pop().unwrap() * s[s.len() - 1];
        }
        res
    }
}