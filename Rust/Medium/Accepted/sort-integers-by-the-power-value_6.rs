impl Solution {
    pub fn get_kth(lo: i32, hi: i32, k: i32) -> i32 {
        
        let mut power = vec![];
        for i in lo..hi+1 {
            power.push((i, Self::get_power(i)));
        }
        power.sort_by(|a, b| {
            if a.1 == b.1 {
                a.0.cmp(&b.0)
            } else {
                a.1.cmp(&b.1)
            }
        });
        power[k as usize - 1].0
    }
    fn get_power(mut n: i32) -> i32 {
        let mut steps = 0;
        while n != 1 {
            if n & 1 == 0 {
                n >>= 1;
            } else {
                n = 3 * n + 1;
            }
            steps += 1;
        }
        steps
    }
}