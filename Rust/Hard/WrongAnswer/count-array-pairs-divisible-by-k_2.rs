impl Solution {
    pub fn count_pairs(nums: Vec<i32>, k: i32) -> i64 {
        
        let n = nums.len();
        let mut counts = vec![0; k as usize];
        for &x in nums.iter() {
            counts[(x % k) as usize] += 1;
        }
        let mut ans = 0;
        for i in 0..k {
            let j = (k - i) % k;
            if i == j {
                ans += counts[i as usize] as i64 * (counts[i as usize] - 1) as i64 / 2;
            } else {
                ans += counts[i as usize] as i64 * counts[j as usize] as i64;
            }
        }
        ans
    }
}