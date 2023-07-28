impl Solution {
    pub fn find_kth_number(n: i32, k: i32) -> i32 {
        
        let mut k = k;
        let mut cur = 1;
        while k > 1 {
            let mut step = 0;
            let mut first = cur;
            let mut last = cur + 1;
            while first <= n {
                step += (last - first).min(n as i64 + 1 - first) as i32;
                first *= 10;
                last *= 10;
            }
            if step < k {
                k -= step;
                cur += 1;
            } else {
                k -= 1;
                cur *= 10;
            }
        }
        cur
    }
}