impl Solution {
    pub fn range_sum(nums: Vec<i32>, n: i32, left: i32, right: i32) -> i32 {
        
        let mut sum = 0;
        let mut subsums = vec![];
        for i in 0..n {
            sum += nums[i as usize];
            subsums.push(sum);
        }
        for i in 1..n {
            for j in i + 1..n {
                sum += subsums[j as usize] - subsums[i as usize - 1];
                subsums.push(sum);
            }
        }
        subsums.sort();
        let mut ans = 0;
        for i in left - 1..right {
            ans += subsums[i as usize];
            ans %= 1000000007;
        }
        ans
    }
}