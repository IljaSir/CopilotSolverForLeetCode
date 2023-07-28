impl Solution {
    pub fn count_arrangement(n: i32) -> i32 {
        

        let mut nums = vec![];
        for i in 1..=n {
            nums.push(i as usize);
        }
        Self::count_arrangement_helper(&mut nums, 0)
    }
    fn count_arrangement_helper(nums: &mut Vec<usize>, i: usize) -> i32 {
        if i == nums.len() {
            return 1;
        }
        let mut count = 0;
        for j in i..nums.len() {
            if nums[j] % (i + 1) == 0 || (i + 1) % nums[j] == 0 {
                nums.swap(i, j);
                count += Self::count_arrangement_helper(nums, i + 1);
                nums.swap(i, j);
            }
        }
        count
    }
}