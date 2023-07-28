impl Solution {
    pub fn array_nesting(nums: Vec<i32>) -> i32 {
        

        let mut visited = vec![false; nums.len()];
        let mut max = 0;
        for i in 0..nums.len() {
            if !visited[i] {
                let mut count = 0;
                let mut j = i;
                while !visited[j] {
                    visited[j] = true;
                    j = nums[j] as usize;
                    count += 1;
                }
                max = max.max(count);
            }
        }
        max as i32
    }
}