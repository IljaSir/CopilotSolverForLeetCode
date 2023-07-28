impl Solution {
    pub fn halve_array(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut sum = nums.iter().sum::<i32>();
        let mut ans = 0;
        while sum >= nums.iter().sum::<i32>() * 2 {
            sum -= nums.pop().unwrap();
            ans += 1;
        }
        ans
    }
}