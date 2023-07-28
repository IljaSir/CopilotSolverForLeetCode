impl Solution {
    pub fn array_nesting(nums: Vec<i32>) -> i32 {
        

        let mut visited = vec![false; nums.len()];
        let mut max_len = 0;
        for i in 0..nums.len() {
            if visited[i] {
                continue;
            }
            let mut len = 0;
            let mut j = i;
            while !visited[j] {
                visited[j] = true;
                j = nums[j] as usize;
                len += 1;
            }
            max_len = max_len.max(len);
        }
        max_len
    }
}