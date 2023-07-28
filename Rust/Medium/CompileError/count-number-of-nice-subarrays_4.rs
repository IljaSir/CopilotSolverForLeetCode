impl Solution {
    pub fn number_of_subarrays(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut res = 0;
        let mut odd = 0;
        let mut cnt = vec![0; nums.len() + 1];
        for num in nums {
            if num % 2 == 1 {
                odd += 1;
            }
            if odd >= k {
                cnt[odd as usize] += 1;
            }
        }
        odd = 0;
        for num in nums {
            if num % 2 == 1 {
                odd += 1;
            }
            if odd >= k {
                res += cnt[odd as usize - k as usize];
            }
        }
        res
    }
}