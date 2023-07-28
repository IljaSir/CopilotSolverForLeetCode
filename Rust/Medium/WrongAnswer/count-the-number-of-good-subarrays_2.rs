impl Solution {
    pub fn count_good(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut res = 0;
        let mut count = vec![0; nums.len() + 1];
        let mut odd = 0;
        count[0] = 1;
        for num in nums {
            odd += num & 1;
            if odd >= k {
                res += count[(odd - k) as usize];
            }
            count[odd as usize] += 1;
        }
        res
    }
}