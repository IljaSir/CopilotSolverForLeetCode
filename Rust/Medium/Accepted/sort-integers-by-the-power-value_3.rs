impl Solution {
    pub fn get_kth(lo: i32, hi: i32, k: i32) -> i32 {
        
        let mut v: Vec<(i32, i32)> = (lo..=hi).map(|x| (x, Self::power(x))).collect();
        v.sort_by(|a, b| {
            if a.1 == b.1 {
                a.0.cmp(&b.0)
            } else {
                a.1.cmp(&b.1)
            }
        });
        v[k as usize - 1].0
    }
    fn power(mut n: i32) -> i32 {
        let mut count = 0;
        while n != 1 {
            count += 1;
            if n % 2 == 0 {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
        }
        count
    }
}