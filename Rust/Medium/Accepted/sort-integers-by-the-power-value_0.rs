impl Solution {
    pub fn get_kth(lo: i32, hi: i32, k: i32) -> i32 {
        
        let mut v = Vec::new();
        for i in lo..=hi {
            let mut n = i;
            let mut count = 0;
            while n != 1 {
                if n % 2 == 0 {
                    n /= 2;
                } else {
                    n = 3 * n + 1;
                }
                count += 1;
            }
            v.push((count, i));
        }
        v.sort();
        v[k as usize - 1].1
    }
}