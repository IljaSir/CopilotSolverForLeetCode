impl Solution {
    pub fn count_distinct_integers(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        nums.dedup();
        let mut res = nums.len();
        for i in 0..nums.len() {
            let mut num = nums[i];
            while num > 0 {
                if nums.binary_search(&(num % 10)).is_err() {
                    res += 1;
                    nums.push(num % 10);
                    nums.sort();
                    nums.dedup();
                }
                num /= 10;
            }
        }
        res as i32
    }
}