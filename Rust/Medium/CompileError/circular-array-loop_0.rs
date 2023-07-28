impl Solution {
    pub fn circular_array_loop(nums: Vec<i32>) -> bool {
        

        let n = nums.len();
        let mut visited = vec![false; n];
        for i in 0..n {
            if visited[i] {
                continue;
            }
            let mut slow = i;
            let mut fast = i;
            let mut direction = nums[i] > 0;
            loop {
                slow = (slow + nums[slow] as usize) % n;
                if direction != nums[slow] > 0 {
                    break;
                }
                fast = (fast + nums[fast] as usize) % n;
                if direction != nums[fast] > 0 {
                    break;
                }
                fast = (fast + nums[fast] as usize) % n;
                if direction != nums[fast] > 0 {
                    break;
                }
                if slow == fast {
                    if slow != (slow + nums[slow] as usize) % n {
                        return true;
                    }
                    break;
                }
            }
            let mut j = i;
            while !visited[j] {
                visited[j] = true;
                j = (j + nums[j] as usize) % n;
            }
        }
        false
    }
}