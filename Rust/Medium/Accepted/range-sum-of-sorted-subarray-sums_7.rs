impl Solution {
    pub fn range_sum(nums: Vec<i32>, n: i32, left: i32, right: i32) -> i32 {
        
        let mut sum = 0;
        let mut subarr = Vec::new();
        for i in 0..n as usize {
            sum = 0;
            for j in i..n as usize {
                sum += nums[j];
                subarr.push(sum);
            }
        }
        subarr.sort();
        let mut ans = 0;
        for i in left as usize - 1..right as usize {
            ans += subarr[i];
            ans %= 1000000007;
        }
        ans
    }
}