impl Solution {
    pub fn count_fair_pairs(nums: Vec<i32>, lower: i32, upper: i32) -> i64 {
        
        let mut res = 0;
        let mut sum = 0;
        let mut cnt = vec![0; 20001];
        cnt[10000] = 1;
        for i in 0..nums.len() {
            sum += nums[i];
            for j in lower..=upper {
                res += cnt[(sum - j + 10000) as usize];
            }
            cnt[(sum + 10000) as usize] += 1;
        }
        res
    }
}