impl Solution {
    pub fn get_kth(lo: i32, hi: i32, k: i32) -> i32 {
        
        let mut powers = Vec::new();
        for i in lo..=hi {
            powers.push((i, Self::power(i)));
        }
        powers.sort_by(|a, b| {
            if a.1 == b.1 {
                a.0.cmp(&b.0)
            } else {
                a.1.cmp(&b.1)
            }
        });
        powers[k as usize - 1].0
    }
    fn power(mut x: i32) -> i32 {
        let mut power = 0;
        while x != 1 {
            if x % 2 == 0 {
                x /= 2;
            } else {
                x = 3 * x + 1;
            }
            power += 1;
        }
        power
    }
}