impl Solution {
    pub fn construct_array(n: i32, k: i32) -> Vec<i32> {
        

        let mut res = Vec::new();
        let (mut l, mut r) = (1, n);
        for i in 0..k {
            if i % 2 == 0 {
                res.push(l);
                l += 1;
            } else {
                res.push(r);
                r -= 1;
            }
        }
        if k % 2 == 0 {
            res.extend(l..=r);
        } else {
            res.extend((l..=r).rev());
        }
        res
    }
}