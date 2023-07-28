impl Solution {
    pub fn min_integer(num: String, k: i32) -> String {
        
        let mut num = num.into_bytes();
        let mut k = k as usize;
        let n = num.len();
        let mut pos = vec![0; n];
        for i in 0..n {
            pos[i] = i;
        }
        for i in 0..n {
            let mut j = i;
            for k in (i..n).take(k + 1) {
                if num[pos[k]] < num[pos[j]] {
                    j = k;
                }
            }
            k -= j - i;
            let mut t = j;
            while t > i {
                pos.swap(t - 1, t);
                t -= 1;
            }
        }
        let mut res = String::new();
        for i in 0..n {
            res.push(num[pos[i]] as char);
        }
        res
    }
}