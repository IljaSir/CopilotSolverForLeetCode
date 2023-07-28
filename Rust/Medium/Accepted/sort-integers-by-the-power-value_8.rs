impl Solution {
    pub fn get_kth(lo: i32, hi: i32, k: i32) -> i32 {
        
        let mut nums = (lo..=hi).collect::<Vec<i32>>();
        nums.sort_by_key(|&i| (Self::power(i), i));
        nums[k as usize - 1]
    }
    fn power(n: i32) -> i32 {
        let mut n = n;
        let mut steps = 0;
        while n != 1 {
            if n % 2 == 0 {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
            steps += 1;
        }
        steps
    }
}