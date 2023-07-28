impl Solution {
    pub fn circular_array_loop(nums: Vec<i32>) -> bool {
        

        let n = nums.len();
        let mut visited = vec![0; n];
        for i in 0..n {
            if visited[i] == 1 {
                continue;
            }
            let mut j = i;
            let mut k = (j as i32 + nums[j]) as usize % n;
            let mut direction = nums[j] > 0;
            let mut count = 1;
            while direction == (nums[k] > 0) && visited[k] == 0 {
                j = k;
                k = (j as i32 + nums[j]) as usize % n;
                count += 1;
            }
            if k == i && count > 1 {
                return true;
            }
            j = i;
            visited[j] = 1;
            while j != k {
                j = (j as i32 + nums[j]) as usize % n;
                visited[j] = 1;
            }
        }
        false
    }
}