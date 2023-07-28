impl Solution {
    pub fn wiggle_max_length(nums: Vec<i32>) -> i32 {
        

        let mut up = vec![0; nums.len()];
        let mut down = vec![0; nums.len()];
        for i in 1..nums.len() {
            for j in 0..i {
                if nums[i] > nums[j] {
                    up[i] = up[i].max(down[j] + 1);
                } else if nums[i] < nums[j] {
                    down[i] = down[i].max(up[j] + 1);
                }
            }
        }
        up.into_iter().chain(down.into_iter()).max().unwrap_or(0) + 1
    }
}