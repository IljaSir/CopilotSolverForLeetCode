impl Solution {
    pub fn get_kth(lo: i32, hi: i32, k: i32) -> i32 {
        
        let mut powers = vec![];
        for i in lo..hi+1 {
            powers.push((i, Solution::power(i)));
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
    
    fn power(mut n: i32) -> i32 {
        let mut steps = 0;
        while n != 1 {
            if n % 2 == 0 {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
            steps += 1;
        }
        steps
    }
}