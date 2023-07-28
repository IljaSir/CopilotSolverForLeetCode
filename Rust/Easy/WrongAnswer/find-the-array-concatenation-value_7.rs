impl Solution {
    pub fn find_the_array_conc_val(nums: Vec<i32>) -> i64 {
        
        let mut nums = nums;
        let mut res = 0;
        while !nums.is_empty() {
            let (a, b) = (nums[0], nums[nums.len() - 1]);
            res += format!("{}{}", a, b).parse::<i64>().unwrap();
            nums.remove(0);
            if !nums.is_empty() {
                nums.remove(nums.len() - 1);
            }
        }
        res
    }
}