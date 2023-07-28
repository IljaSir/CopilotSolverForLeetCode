impl Solution {
    pub fn array_nesting(nums: Vec<i32>) -> i32 {
        

        let mut visited = vec![false; nums.len()];
        let mut max = 0;
        for i in 0..nums.len() {
            if visited[i] {
                continue;
            }
            let mut count = 1;
            let mut j = nums[i] as usize;
            while j != i {
                j = nums[j] as usize;
                count += 1;
                visited[j] = true;
            }
            if count > max {
                max = count;
            }
        }
        max as i32
    }
}