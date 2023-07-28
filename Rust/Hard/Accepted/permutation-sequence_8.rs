impl Solution {
    pub fn get_permutation(n: i32, k: i32) -> String {
        
        let mut n = n;
        let mut k = k;
        let mut r = String::new();
        let mut v = Vec::new();
        let mut f = 1;
        for i in 1..=n {
            v.push(i);
            f *= i;
        }
        for i in (1..=n).rev() {
            f /= i;
            let j = (k - 1) / f;
            r.push((v[j as usize] + '0' as i32) as u8 as char);
            v.remove(j as usize);
            k -= j * f;
        }
        r
    }
}