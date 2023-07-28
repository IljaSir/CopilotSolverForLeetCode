impl Solution {
    pub fn get_permutation(n: i32, k: i32) -> String {
        
        let mut k = k;
        let mut n = n;
        let mut v = Vec::new();
        let mut f = 1;
        for i in 1..=n {
            f *= i;
            v.push(i);
        }
        let mut res = String::new();
        for i in 0..n {
            f /= n - i;
            let mut j = (k - 1) / f;
            k -= j * f;
            res.push((v[j as usize] + 48) as u8 as char);
            v.remove(j as usize);
        }
        res
    }
}