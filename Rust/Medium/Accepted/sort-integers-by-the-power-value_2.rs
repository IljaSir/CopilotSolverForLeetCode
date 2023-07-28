impl Solution {
    pub fn get_kth(lo: i32, hi: i32, k: i32) -> i32 {
        
        let mut v = Vec::new();
        for i in lo..hi+1 {
            let mut t = i;
            let mut c = 0;
            while t != 1 {
                if t % 2 == 0 {
                    t /= 2;
                } else {
                    t = 3 * t + 1;
                }
                c += 1;
            }
            v.push((c, i));
        }
        v.sort();
        v[k as usize - 1].1
    }
}