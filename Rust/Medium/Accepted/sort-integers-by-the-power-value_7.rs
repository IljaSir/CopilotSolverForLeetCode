impl Solution {
    pub fn get_kth(lo: i32, hi: i32, k: i32) -> i32 {
        
        let mut res = Vec::new();
        for i in lo..hi+1 {
            res.push((i, Self::get_power(i)));
        }
        res.sort_by(|a, b| {
            if a.1 == b.1 {
                a.0.cmp(&b.0)
            } else {
                a.1.cmp(&b.1)
            }
        });
        res[k as usize - 1].0
    }
    fn get_power(mut n: i32) -> i32 {
        let mut res = 0;
        while n != 1 {
            res += 1;
            if n % 2 == 0 {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
        }
        res
    }
}