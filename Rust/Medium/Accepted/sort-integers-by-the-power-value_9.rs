impl Solution {
    pub fn get_kth(lo: i32, hi: i32, k: i32) -> i32 {
        
        let mut nums: Vec<(i32, i32)> = (lo..=hi).map(|i| (i, Self::step(i))).collect();
        nums.sort_by(|a, b| if a.1 == b.1 {
            a.0.cmp(&b.0)
        } else {
            a.1.cmp(&b.1)
        });
        nums[k as usize - 1].0
    }
    fn step(mut n: i32) -> i32 {
        if n == 1 {
            return 0;
        }
        let mut res = 0;
        while n != 1 {
            if n % 2 == 0 {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
            res += 1;
        }
        res
    }
}