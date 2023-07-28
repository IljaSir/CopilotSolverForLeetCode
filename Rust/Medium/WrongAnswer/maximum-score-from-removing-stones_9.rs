impl Solution {
    pub fn maximum_score(a: i32, b: i32, c: i32) -> i32 {
        
        let mut v = vec![a, b, c];
        v.sort();
        let mut s = 0;
        while v[2] > 0 {
            if v[1] > 0 {
                v[1] -= 1;
                v[2] -= 1;
                s += 1;
            } else {
                v[2] -= 2;
                s += 1;
            }
            v.sort();
        }
        s
    }
}