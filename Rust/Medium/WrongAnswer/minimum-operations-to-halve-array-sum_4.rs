impl Solution {
    pub fn halve_array(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut sum = nums.iter().sum::<i32>();
        let mut res = 0;
        while sum > 0 {
            let n = nums.pop().unwrap();
            sum -= n;
            res += 1;
            if sum * 2 < n {
                break;
            }
        }
        res
    }
}