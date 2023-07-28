impl Solution {
    pub fn find_duplicates(nums: Vec<i32>) -> Vec<i32> {
        

        let mut ans: Vec<i32> = Vec::new();
        let mut nums = nums;
        for i in 0..nums.len() {
            let num = nums[i].abs();
            let index = (num - 1) as usize;
            if nums[index] < 0 {
                ans.push(num);
            } else {
                nums[index] = -nums[index];
            }
        }
        ans
    }
}