impl Solution {
    pub fn array_nesting(nums: Vec<i32>) -> i32 {
        

        let mut max = 0;
        let mut visited = vec![false; nums.len()];
        for i in 0..nums.len() {
            if visited[i] {
                continue;
            }
            let mut j = i;
            let mut count = 0;
            while !visited[j] {
                visited[j] = true;
                j = nums[j] as usize;
                count += 1;
            }
            if count > max {
                max = count;
            }
        }
        max
    }
}