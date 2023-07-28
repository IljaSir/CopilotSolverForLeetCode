impl Solution {
    pub fn maximum_score(a: i32, b: i32, c: i32) -> i32 {
        
        let mut a = a;
        let mut b = b;
        let mut c = c;
        let mut res = 0;
        let mut v = vec![a, b, c];
        v.sort();
        if v[0] + v[1] <= v[2] {
            return v[0] + v[1];
        }
        res += v[2];
        v[0] -= 1;
        v[1] -= 1;
        v.sort();
        if v[0] + v[1] <= v[2] {
            return res + v[0] + v[1];
        }
        res += (v[0] + v[1] - v[2]) / 2;
        res
    }
}