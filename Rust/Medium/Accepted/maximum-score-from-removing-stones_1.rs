impl Solution {
    pub fn maximum_score(a: i32, b: i32, c: i32) -> i32 {
        
        let mut v = vec![a, b, c];
        v.sort();
        let (a, b, c) = (v[0], v[1], v[2]);
        if a + b <= c {
            a + b
        } else {
            (a + b + c) / 2
        }
    }
}